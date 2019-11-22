/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Janio
 */
public class TrataImagem {

    private BufferedImage imagem;

    public TrataImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public TrataImagem(InputStream imagem) {
        try {
            this.imagem = ImageIO.read(imagem);
        } catch (IOException ex) {
            Logger.getLogger(TrataImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InputStream getCropRedacao() {
        return corta(0, 410, this.imagem.getWidth(), this.imagem.getHeight() - 410);
    }

    public InputStream getCropPAAESDesParteSup() {
        return corta(0, 260, this.imagem.getWidth(), this.imagem.getHeight() - 260);
    }

    public InputStream getCropPedacinhoSuperior() {
        return corta(0, 30, this.imagem.getWidth(), this.imagem.getHeight() - 30);
    }

    public InputStream getCropPedacoMedioSuperior() {
        return corta(0, 80, this.imagem.getWidth(), this.imagem.getHeight() - 80);
    }

    public InputStream getCropPedacinhoDireita() {
        return corta(0, 0, this.imagem.getWidth() - 10, this.imagem.getHeight());
    }
    

    public InputStream getCropPAAESFilipeta() {
        return corta(0, 0, this.imagem.getWidth() - 730, this.imagem.getHeight());
    }

    private InputStream corta(int x, int y, int z, int w) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedImage resultado = this.imagem.getSubimage(x, y, z, w);
            ImageIO.write(resultado, "JPEG", baos);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            return is;
        } catch (IOException ex) {

            Logger.getLogger(TrataImagem.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private BufferedImage roda90DX(BufferedImage bi) {
        int width = bi.getWidth();
        int height = bi.getHeight();

        BufferedImage biFlip = new BufferedImage(height, width, bi.getType());

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //biFlip.setRGB(height - 1 - j, width - 1 - i, bi.getRGB(i, j));
                biFlip.setRGB(height-1-j, i, bi.getRGB(i, j));
            }
        }

        return biFlip;
    }
    
    private BufferedImage roda90SX(BufferedImage bi) {
        int width = bi.getWidth();
        int height = bi.getHeight();

        BufferedImage biFlip = new BufferedImage(height, width, bi.getType());

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //biFlip.setRGB(j, i, bi.getRGB(i, j));
                biFlip.setRGB(j, width-1-i, bi.getRGB(i, j));
            }
        }

        return biFlip;
    }
    
    public InputStream rotate90Direita() {
        return this.converteBufferedImageParaInputStream(this.roda90DX(this.imagem));
    }

    public InputStream rotate90Direita2Vezes() {
        return this.converteBufferedImageParaInputStream(this.roda90DX(this.roda90DX(this.imagem)));
    }
    
    public InputStream rotate90Esquerda() { 
        return this.converteBufferedImageParaInputStream(this.roda90SX(this.imagem));
    }
    
    public InputStream rotate90Esquerda2Vezes() { 
        return this.converteBufferedImageParaInputStream(this.roda90SX(this.roda90SX(this.imagem)));
    }
    
    
    private InputStream converteBufferedImageParaInputStream(BufferedImage converte){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(converte, "JPEG", baos);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            return is;
        } catch (IOException ex) {
            Logger.getLogger(TrataImagem.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static byte[] fromInputStreamToByte(InputStream is){
        try {
            ByteArrayOutputStream buffer=new ByteArrayOutputStream();
            
            int nRead;
            byte[] dados = new byte[4096];
            while( (nRead=is.read(dados, 0, dados.length) ) != -1 ){
                buffer.write(dados,0,nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(TrataImagem.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    
    }
    //
    
            
    public InputStream getCropPedacinhoInferior() {
        return corta(0, 0, this.imagem.getWidth(), this.imagem.getHeight() - 20);
    }

    public InputStream cortaFilipetaDireita() {
        return corta(0, 0, this.imagem.getWidth() - 30, this.imagem.getHeight());
    }

    public InputStream giraParaDireita() {
        return this.rotate90Direita();
    }
    public InputStream giraParaEsquerda() {
        return this.rotate90Esquerda();
    }
    
}
