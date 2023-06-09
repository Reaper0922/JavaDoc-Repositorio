package main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author joel
 */
public class Carta
{
    private int valor;
    private char simbolo;
    private String reference;
    private boolean cartaVirada;
    private ImageIcon cartaFrente;
    private ImageIcon cartaAtras;
    private static final String URLIMAGEM = "src/Imagens/";
    private static final String extensoesImagem = ".gif";

    /**
     *
     */
    public Image im;
    String codigo;
    private boolean cor;

    /**
     *
     */
    public int id;
    private static final int LARGURA_CARTA = 400; //125;
    private static final int ALTURA_CARTA = 200; //150;

    /**
     *
     */
    public Carta proximo;

    /**
     *
     */
    public Carta anterior;
    Carta cartaAux;

    /**
     *
     */
    public static String cardBackFilename = "b",

    /**
     *
     */
    cardOutlineFilename = "bottom01",

    /**
     *
     */
    fpBaseFilename = "fpBase0";
    
    /**
     *
     */
    public Carta() {
        
    }
    
    /**
     *
     * @param valor
     * @param simbolo
     * @param reference
     */
    public Carta(int valor, char simbolo, String reference) 
    {
        if(simbolo == 'h' || simbolo == 'd') {
            this.cor = true;
        } else {
            this.cor = false;
        }
        ImageIcon ii = new ImageIcon((URLIMAGEM + (reference + simbolo) + extensoesImagem));
        im = ii.getImage();
        this.valor = valor;
        this.simbolo = simbolo;
        this.reference = reference;
        cartaVirada = true;
    }

    /**
     *
     * @param suit
     * @return
     */
    public static Image getFoundationBase(int suit) {
        ImageIcon ii;
        ii = new ImageIcon((URLIMAGEM + fpBaseFilename + suit + extensoesImagem));
        Image image = ii.getImage();
        return image;
    }

    /**
     *
     * @return
     */
    public static Image getCardOutline() {
        ImageIcon ii = new ImageIcon((URLIMAGEM + cardOutlineFilename + extensoesImagem));
        Image image = ii.getImage();
        return image;
    }

    /**
     *
     * @return
     */
    public static Image getCardBack() {
        ImageIcon ii = new ImageIcon((URLIMAGEM + cardBackFilename + extensoesImagem));
        Image image = ii.getImage();
        return image;
    }

    /**
     *
     * @return
     */
    public Image getCardImage() {
	return im;
    }

    /**
     *
     */
    public void showFace() {
	 cartaVirada = true;
    }

    /**
     *
     * @return
     */
    public boolean isCartaVirada() {
        return cartaVirada;
    }

    /**
     *
     * @return
     */
    public int getValue() {
	return valor;
    }

    /**
     *
     * @return
     */
    public char getSuit() {
        return simbolo;
    }

    /**
     *
     * @return
     */
    public String getCodigo() {
        return this.getReference() + this.getSimbolo();
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public boolean isCor() {
        return cor;
    }

    /**
     *
     * @param cor
     */
    public void setCor(boolean cor) {
        this.cor = cor;
    }

    /**
     *
     * @return
     */
    public String getReference() {
        return reference;
    }

    /**
     *
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    /**
     *
     * @return
     */
    public int getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public char getSimbolo() {
        return simbolo;
    }
    
    /**
     *
     * @return
     */
    public Image getImage() {
        return this.isCartaVirada() == true ? this.getCartaAtras().getImage() : this.getCartaFrente().getImage();
    }

    /**
     *
     * @param simbolo
     */
    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Carta{");
        sb.append(this.getValor());
        sb.append(", ");
        sb.append( this.getSimbolo());
        sb.append(", " );
        sb.append( this.getReference() );
        sb.append(", Virada: " + this.isCartaVirada());
        sb.append( '}');
        return sb.toString();
    }

    /**
     *
     * @param type
     * @return
     */
    public ListaLigada generateCarta(char type) 
    {
        ListaLigada cartas = new ListaLigada();
        String codigo;
        Image imagem;
        boolean cor;
        
        if(type == 'h' || type == 'd') {
            cor = true;
        } else {
            cor = false;
        }
        
        cartaAux = new Carta(1, type, "a");
        cartaAux.codigo = "a" + type;

        cartaAux.cartaFrente = new ImageIcon((URLIMAGEM + cartaAux.codigo + extensoesImagem));
        cartaAux.cartaAtras = new ImageIcon((URLIMAGEM + 'b' + extensoesImagem));
        cartaAux.cor = cor;
        cartas.inserirFim(cartaAux);
        
        for(int i = 1; i <= 9; i++) {
            cartaAux = new Carta(i + 1, type, "" + (i + 1));
            cartaAux.codigo = cartaAux.getReference() + cartaAux.getSimbolo();
            cartaAux.cartaFrente = new ImageIcon((URLIMAGEM + cartaAux.codigo + extensoesImagem));
            cartaAux.cartaAtras = new ImageIcon((URLIMAGEM + 'b' + extensoesImagem));
            cartaAux.cor = cor;
            cartas.inserirFim(cartaAux);
        }
        
        cartaAux = new Carta(11, type, "j");
        cartaAux.codigo = "j" + type;
        cartaAux.cartaFrente = new ImageIcon((URLIMAGEM + cartaAux.codigo + extensoesImagem));
        cartaAux.cartaAtras = new ImageIcon((URLIMAGEM + 'b' + extensoesImagem));
        cartaAux.cor = cor;
        cartas.inserirFim(cartaAux);

        cartaAux = new Carta(12, type, "q");
        cartaAux.codigo = "q" + type;
        cartaAux.cartaFrente = new ImageIcon((URLIMAGEM + cartaAux.codigo + extensoesImagem));
        cartaAux.cartaAtras = new ImageIcon((URLIMAGEM + 'b' + extensoesImagem));
        cartaAux.cor = cor;
        cartas.inserirFim(cartaAux);
        
        cartaAux = new Carta(13, type, "k");
        cartaAux.codigo = "k" + type;
        cartaAux.cartaFrente = new ImageIcon((URLIMAGEM + cartaAux.codigo + extensoesImagem));
        cartaAux.cartaAtras = new ImageIcon((URLIMAGEM + 'b' + extensoesImagem));
        cartaAux.cor = cor;
        cartas.inserirFim(cartaAux);

        return cartas;
    }

    /**
     *
     * @param cartaVirada
     */
    public void setCartaVirada(boolean cartaVirada) {
        this.cartaVirada = cartaVirada;
    }

    /**
     *
     * @return
     */
    public ImageIcon getCartaFrente() {
        return cartaFrente;
    }

    /**
     *
     * @param cartaFrente
     */
    public void setCartaFrente(ImageIcon cartaFrente) {
        this.cartaFrente = cartaFrente;
    }

    /**
     *
     * @return
     */
    public ImageIcon getCartaAtras() {
        return cartaAtras;
    }

    /**
     *
     * @param cartaAtras
     */
    public void setCartaAtras(ImageIcon cartaAtras) {
        this.cartaAtras = cartaAtras;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Carta getProximo() {
        return proximo;
    }

    /**
     *
     * @param proximo
     */
    public void setProximo(Carta proximo) {
        this.proximo = proximo;
    }
    /*
     @Override
    public void mouseClicked(MouseEvent e) 
    {
        Component pressedComponent = e.getComponent().getComponentAt(e.getPoint());
        if (pressedComponent instanceof Carta) {
            System.out.println("snjns");
            System.out.println(pressedComponent);
        }
       // if( e.getSource() == cartaAux)
       // {
            System.out.println("Foi clicado");
             System.out.println(""+cartaAux.codigo);
                        
       // }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
          //if( e.getSource() == cartaAux)
       // {
            // System.out.println(""+codigo);
                        
            //System.out.println("Foi clicado");
        //}
    }

    @Override
    public void mouseDragged(MouseEvent e) {
              //if( e.getSource() == cartaAux)
        
           // System.out.println("Foi clicado");
            // System.out.println(""+codigo);
                        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
              
        
           // System.out.println("Foi clicado");
            // System.out.println(""+codigo);
                        
        
    }*/

    void setListID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
