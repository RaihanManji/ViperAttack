/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viperattack;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Snake {
    private ArrayList<Point> body;
    Direction direction = Direction.RIGHT;
    
    
    {
        body = new ArrayList<>();
    }
    
    public void move(){
        // create a new location for the head, usinfg the direction 
       int x = 0;
       int y = 0;
        
       
       switch (direction){
           case UP:
               x = 0;
               y = -1;
               break; 
               
        case DOWN:
               x = 0;
               y = 1;
               break; 
                       
         case RIGHT:
               x = 1;
               y = 0;
               break; 
       
         case LEFT:
               x = -1;
               y = 0;
               break; 
                               
                               
       }
       
        
       body.add(0, new Point(getHead().x + x, getHead().y + y));
       //delete body
       body.remove(body.size() - 1);
       
    }
    
    public void grow()  {
        body.add(0,new Point(getHead().x, getHead().y));
    }
    
    public void shrink()  {
        body.remove(body.size() - 1);
    }
    
    public Point getHead(){
        return body.get(0);
    }
    
    public boolean selfHitTest(){
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).equals(getHead() )) {
                return true;
                
            }
        }
        
        return false;
        
    }
    
    //private ArrayList<Point> body;

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }
    
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
}
