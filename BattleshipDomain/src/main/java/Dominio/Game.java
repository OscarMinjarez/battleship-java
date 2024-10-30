package Dominio;


public class Game {

   
    private GameState state;
    private Player turn;
    private Player[] player = new Player[2]; // Arreglo de dos jugadores

 

    public Table[] getPlayerTables() {
        
        return null;
    }

    
    public void shoot(Coordiante point) {
        
    }

   /** 
     * 
     *  
     */
    public void swapTurn() {
        
    }

    /** 
     * 
     *  
     */
    private boolean verifyShoot() {
        
              
        return false;
    }
    
    /** 
     * 
     *  
     */
    public GameState getState() {
        return state;
    }

    /** 
     * 
     *  
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /** 
     * 
     *  
     */
    public Player getTurn() {
        return turn;
    }
    
    /** 
     * 
     *  
     */
    public void setTurn(Player turn) {
        this.turn = turn;
    }
    
    /** 
     * 
     *  
     */
    public Player[] getPlayer() {
        return player;
    }

    /** 
     * 
     *  
     */
    public void setPlayer(Player[] player) {
        this.player = player;
    }

    /** 
     * 
     *  
     */
    @Override
    public String toString() {
        return "Game{" + "state=" + state + ", turn=" + turn + ", player=" + player + '}';
    }
    
    
}
