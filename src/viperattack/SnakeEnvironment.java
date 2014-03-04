/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viperattack;

import audio.AudioPlayer;
import environment.Environment;
import environment.GraphicsPalette;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author User
 */
class SnakeEnvironment extends Environment {

    private GameState gameState = GameState.PAUSED;
    private Grid grid;
    private int score = 0;
    private Snake snake;
    private ArrayList<Point> apples;

    private ArrayList<Point> bottles;

    private ArrayList<Point> poutines;

    private ArrayList<Point> walls;

    private int delay = 0;
    private int moveCounter = delay;
    private Image poutine;

    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/blue2.jpg"));
        this.poutine = ResourceTools.loadImageFromResource("resources/poutine.png");

        this.grid = new Grid();
        this.grid.setColor(Color.ORANGE);
        this.grid.setColumns(75);
        this.grid.setCellWidth(20);
        this.grid.setCellHeight(18);
        this.grid.setRows(40);
        this.grid.setPosition(new Point(50, 100));

        this.apples = new ArrayList<Point>();
        this.apples.add(new Point(10, 12));

        for (int i = 0; i < 15; i++) {
            this.apples.add(getRandomGridLocation());
        }

        this.bottles = new ArrayList<Point>();
        this.bottles.add(new Point(12, 34));

        for (int i = 0; i < 15; i++) {
            this.bottles.add(getRandomGridLocation());
        }

        this.walls = new ArrayList<Point>();
        this.walls.add(new Point(3, 3));
        this.walls.add(new Point(3, 4));
        this.walls.add(new Point(4, 3));
        this.walls.add(new Point(4, 4));

        this.walls.add(new Point(5, 5));
        this.walls.add(new Point(5, 6));
        this.walls.add(new Point(6, 5));
        this.walls.add(new Point(6, 6));

        this.walls.add(new Point(7, 7));
        this.walls.add(new Point(7, 8));
        this.walls.add(new Point(8, 7));
        this.walls.add(new Point(8, 8));

        this.walls.add(new Point(9, 9));
        this.walls.add(new Point(9, 10));
        this.walls.add(new Point(10, 9));
        this.walls.add(new Point(10, 10));

        this.walls.add(new Point(11, 11));
        this.walls.add(new Point(11, 12));
        this.walls.add(new Point(12, 11));
        this.walls.add(new Point(12, 12));

        this.walls.add(new Point(70, 3));
        this.walls.add(new Point(71, 3));
        this.walls.add(new Point(70, 4));
        this.walls.add(new Point(71, 4));

        this.walls.add(new Point(69, 5));
        this.walls.add(new Point(68, 5));
        this.walls.add(new Point(69, 6));
        this.walls.add(new Point(68, 6));

        this.walls.add(new Point(67, 7));
        this.walls.add(new Point(66, 7));
        this.walls.add(new Point(67, 8));
        this.walls.add(new Point(66, 8));

        this.walls.add(new Point(65, 9));
        this.walls.add(new Point(64, 9));
        this.walls.add(new Point(65, 10));
        this.walls.add(new Point(64, 10));

        this.walls.add(new Point(63, 11));
        this.walls.add(new Point(62, 11));
        this.walls.add(new Point(63, 12));
        this.walls.add(new Point(62, 12));

        this.walls.add(new Point(70, 36));
        this.walls.add(new Point(71, 36));
        this.walls.add(new Point(70, 35));
        this.walls.add(new Point(71, 35));

        this.walls.add(new Point(69, 34));
        this.walls.add(new Point(68, 34));
        this.walls.add(new Point(69, 33));
        this.walls.add(new Point(68, 33));

        this.walls.add(new Point(67, 32));
        this.walls.add(new Point(66, 32));
        this.walls.add(new Point(67, 31));
        this.walls.add(new Point(66, 31));

        this.walls.add(new Point(65, 30));
        this.walls.add(new Point(64, 30));
        this.walls.add(new Point(65, 29));
        this.walls.add(new Point(64, 29));

        this.walls.add(new Point(63, 28));
        this.walls.add(new Point(62, 28));
        this.walls.add(new Point(63, 27));
        this.walls.add(new Point(62, 27));

        this.walls.add(new Point(4, 36));
        this.walls.add(new Point(5, 36));
        this.walls.add(new Point(4, 35));
        this.walls.add(new Point(5, 35));

        this.walls.add(new Point(6, 34));
        this.walls.add(new Point(7, 34));
        this.walls.add(new Point(6, 33));
        this.walls.add(new Point(7, 33));

        this.walls.add(new Point(8, 32));
        this.walls.add(new Point(9, 32));
        this.walls.add(new Point(8, 31));
        this.walls.add(new Point(9, 31));

        this.walls.add(new Point(10, 30));
        this.walls.add(new Point(11, 30));
        this.walls.add(new Point(10, 29));
        this.walls.add(new Point(11, 29));

        this.walls.add(new Point(12, 28));
        this.walls.add(new Point(13, 28));
        this.walls.add(new Point(12, 27));
        this.walls.add(new Point(13, 27));

        this.poutines = new ArrayList<Point>();
        //this.poutines.add(getRandomGridLocation());
        //this.poutines.add(getRandomGridLocation());
        for (int i = 0; i < 15; i++) {
            this.poutines.add(getRandomGridLocation());
        }

        this.snake = new Snake();
        this.snake.getBody().add(new Point(40, 40));
        this.snake.getBody().add(new Point(30, 40));
        this.snake.getBody().add(new Point(40, 30));
        this.snake.getBody().add(new Point(30, 30));
    }

    private Point getRandomGridLocation() {
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() * this.grid.getRows()));
    }

    @Override
    public void timerTaskHandler() {
        if (this.gameState == GameState.RUNNING) {

            if (snake != null) {
                if (moveCounter <= 0) {
                    snake.move();
                    moveCounter = delay;
                    checkSnakeIntersection();
                } else {
                    moveCounter--;
                }
            }
        }

        if (snake.getHead().x < 0 || snake.getHead().y < 0 || snake.getHead().x > grid.getColumns() - 1 || snake.getHead().y > grid.getRows() - 1) {
            this.gameState = GameState.ENDED;
        }
    }

    private void checkSnakeIntersection() {
        // if the snake locartion is the same as the apple location
        // then grow the snake and remove the apple
        // later, move the apple and make a sound and increase the score 

        for (int i = 0; i < this.apples.size(); i++) {
            if (snake.getHead().equals(this.apples.get(i))) {
                System.out.println("Apple Chomp");
                this.score += 5;
                this.apples.get(i).x = getRandomGridLocation().x;
                this.apples.get(i).y = getRandomGridLocation().y;
                this.snake.grow();
            }

        }
        for (int i = 0; i < this.poutines.size(); i++) {
            if (snake.getHead().equals(this.poutines.get(i))) {
                System.out.println("Poutine Chomp");
                this.score += 10;
                this.poutines.get(i).x = getRandomGridLocation().x;
                this.poutines.get(i).y = getRandomGridLocation().y;
                this.snake.grow();
                AudioPlayer.play("/resources/dj.wav");
            }
        }

        for (int i = 0; i < this.bottles.size(); i++) {
            if (snake.getHead().equals(this.bottles.get(i))) {
                System.out.println("Bottle Chomp");
                this.score -= 5;
                this.bottles.get(i).x = getRandomGridLocation().x;
                this.bottles.get(i).y = getRandomGridLocation().y;
                this.bottles.get(i).y = getRandomGridLocation().y;
                this.bottles.get(i).x = getRandomGridLocation().x;
                this.snake.shrink();

            }
        }
        
        for (int i = 0; i < this.walls.size(); i++) {
            if (snake.getHead().equals(this.walls.get(i))) {
                System.out.println("Bottle Chomp");
                this.gameState = GameState.ENDED;
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //toggle the PAUSED/RUNNIG state
            if (gameState == GameState.RUNNING) {
                gameState = GameState.PAUSED;
            } else if (gameState == GameState.PAUSED) {
                gameState = GameState.RUNNING;
            } else if (gameState == GameState.ENDED) {
                snake.getHead().x = 20;
                snake.getHead().y = 20;
                gameState = GameState.RUNNING;

            }
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            //check if current direction is exact opposite
            snake.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState = GameState.ENDED;
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (this.grid != null) {
            grid.paintComponent(graphics);

            if (this.apples != null) {
                for (int i = 0; i < this.apples.size(); i++) {
                    GraphicsPalette.drawApple(graphics, this.grid.getCellPosition(this.apples.get(i)), this.grid.getCellSize());
                }
            }

            if (this.walls != null) {
                for (int i = 0; i < this.walls.size(); i++) {
                    graphics.setColor(Color.GRAY);
                    graphics.fill3DRect(this.grid.getCellPosition(this.walls.get(i)).x, this.grid.getCellPosition(this.walls.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, true);
                }
            }

            if (this.bottles != null) {
                for (int i = 0; i < this.bottles.size(); i++) {
                    GraphicsPalette.drawPoisonBottle(graphics, this.grid.getCellPosition(this.bottles.get(i)), this.grid.getCellSize(), Color.BLUE);
                }
            }

            if (this.poutines != null) {
                for (int i = 0; i < this.poutines.size(); i++) {
                    Point poutinePosition = this.grid.getCellPosition(this.poutines.get(i));
                    graphics.drawImage(poutine, poutinePosition.x, poutinePosition.y, this.grid.getCellWidth(), this.grid.getCellHeight(), this);
                }
            }

            Point cellLocation;
            graphics.setColor(Color.ORANGE);
            if (snake != null) {
                for (int i = 0; i < snake.getBody().size(); i++) {
                    cellLocation = grid.getCellPosition(snake.getBody().get(i));
                    graphics.fillOval(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());
                }
            }
        }

        //graphics.drawImage(poutine, 10, 20, this.grid.getCellWidth(), this.grid.getCellHeight(), this);
        graphics.setFont(new Font("Calibri", Font.BOLD, 60));
        graphics.drawString("Score " + this.score, 50, 50);

        graphics.setColor(Color.ORANGE);
        graphics.drawString("W,A,S,D to control and space bar to restart", 320, 95);

        graphics.setFont(new Font("Calibri", Font.BOLD, 60));
        graphics.setColor(Color.ORANGE);
        graphics.drawString("Viper Attack ", 650, 50);

        if (gameState == GameState.ENDED) {
            graphics.setColor(Color.BLUE);
            graphics.setFont(new Font("Calibri", Font.BOLD, 100));
            graphics.drawString("Game Over!!!", 550, 300);
        }

        if (gameState == GameState.PAUSED) {
            graphics.setColor(Color.blue);
            graphics.setFont(new Font("Calibri", Font.BOLD, 100));
            graphics.drawString("Paused", 650, 300);
        }
        
        if (gameState == GameState.PAUSED) {
            graphics.setColor(Color.blue);
            graphics.setFont(new Font("Calibri", Font.BOLD, 100));
            graphics.drawString("Click spacebar to continue", 320, 500);
        }
    }

}
