package main;

/**
 *
 * @Autor Joel
 * Free Use - Livre_Uso
 */
public class ListaMemoria {
   
    NoMemoria primeiro;
    NoMemoria ultimo;
    private int id;
    private int limite = 5;
    int quant;
    
    /**
     *
     */
    public ListaMemoria(){
        this.primeiro = null;
        this.ultimo = null;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return this.quant == 0;
    }
    
    /**
     *
     * @param memoria
     */
    public void inserirInicio(NoMemoria memoria){
        if(isEmpty()){
            this.ultimo = memoria;
        }
        else{
            memoria.proximo = this.primeiro;
            this.primeiro.anterior = memoria;
        }
        this.primeiro = memoria;
        this.quant += 1;
    }
    
    /**
     *
     * @param memoria
     */
    public void inserirFim(NoMemoria memoria){
        if(isEmpty()){
            this.inserirInicio(memoria);
        }
        else{
            if (this.quant < this.limite) {
               this.ultimo.proximo = memoria;
                memoria.anterior = this.ultimo;
                this.ultimo = memoria;
            
                this.quant += 1; 
            } else {
                remoberInicio();
                inserirFim(memoria);
            }
            
        }
    }
    
    /**
     *
     * @return
     */
    public int contList() {
        return this.quant;
    }
    
    /**
     *
     * @return
     */
    public NoMemoria remoberInicio(){
       NoMemoria aux = this.primeiro;
        if (!isEmpty()) {
           this.primeiro = this.primeiro.proximo;
           this.primeiro.anterior = null;
           this.quant -= 1;
       }
       return aux;
    }
    
    /**
     *
     * @return
     */
    public NoMemoria removerFim(){
        NoMemoria aux = ultimo;
        
        if (!this.isEmpty()) {
            this.ultimo = this.ultimo.anterior;
            this.quant -= 1;
        }
        return aux;
    }
    
    /**
     *
     * @param pos
     * @return
     */
    public NoMemoria busca(int pos) {
        if (!this.isEmpty()) {
            NoMemoria cartaAux = this.primeiro;
            
            while(pos > 0) {
                cartaAux = cartaAux.proximo;
                pos--;
            }
            return cartaAux;
        }
        return null;
    }


}
