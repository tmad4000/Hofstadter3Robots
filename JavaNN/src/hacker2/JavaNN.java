/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hacker2;

import javann.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



        

/**
 *
 * @author Jacob
 */
public class JavaNN {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hacker h= new Hacker();
        /*SimpleTMazeBot t= new ModelTMazeBot();
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
        System.out.println(t.makeChoice());
                
        */
        
        // TODO code application logic here
        //Node({i1,i2)},{o1});
        //nn = new NN
        
                
               
     /*
         * logic is a special case of simulated annealing
       why the heck would the computer want to play tic tac toe
               
       why not acting?
               
       that's easy
       just say things in voice
     * #1 get computer to talk, read stuff. sound it out.
       #2 get computer to add inflection and enunciate the important parts
       "i see in your eyes the fear that would take the heart of me"
        play the human instrument
        caring
        play
        dream
     * 
     *
     * 
       awareness
       input is board
       output is play
       */
    }
}
class SimpleTMazeBot {
    
    final static double seed=(Math.sqrt(2.));
    int seedDigit=0;
            
    public SimpleTMazeBot() {
        System.out.println(seed);
    }
    
    
    
    public boolean makeChoice() {
        //if the next digit in sqrt 2 is even...
        return (((int)(seed*Math.pow(10, seedDigit++)))%10)%2==0 ? true : false;
    }
}

class ModelTMazeBot extends SimpleTMazeBot {
    
    ArrayList<Boolean> record=new ArrayList<Boolean>();
    //Model model=new Hacker.BoolModel();
    
    public boolean makeChoice() {
        
        boolean choice=super.makeChoice();
        record(choice);
        return choice;
    }
    
    void record(boolean choice) {
        record.add(choice);
       // model.perceive(choice);
        
        System.out.println(record);
    }
    
    
}

        

class Edge {
    double w;
    Node n1,n2;
    
    public Edge(Node n1,Node n2) {
        this.n1=n1;
        this.n2=n2;
    }
}

class Node {
    
    public Node() {
        
    }
}

class Hacker extends JFrame {
    int rows=6,cols=8;
    final int SCALE=100;
    final int PADDING=10;
    
    int[][] perception;
    Model model;
    
    Color[] COLORS={Color.yellow,Color.blue,Color.green,Color.red};
    
    int[][] goal;
    
    ArrayList<Gestalt> openGs;
    ArrayList<Ability> abilities;

    
    public Hacker() {
        super("Hacker");
       //  setLayout(new FlowLayout());
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        
        init();
        
        
        
        HackerPanel p=new HackerPanel(perception);
        add(p);
        add(new JButton("< Init"));
        add(new JButton("Go"));
        HackerPanel p2=new HackerPanel(goal);
        add(new JButton("Goal >"));
        add(p2);
        
        setSize((cols*SCALE+200)*2,(rows*SCALE+200));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        p.paint
    }
    
    void init() {
        perception=new int[rows][cols];
        perception[0][1]=1;
        perception[0][3]=2;
        perception[1][3]=3;
        setGoal();
    }
    
    void play() {
        /*
        doBestThing();
            doMostGracefulThing()
                    feelBalanceOfTensionSystems()
                            surveryTensionSystems()
                                    desireToWorkTowardsGoal=howMuchFunIsGoal
                                    valueOfNotChangingGoals
                                            
                                    I want to move the block to the target position as if by magic but I can only do limited things
                                    What do I want to do? goal
                                    what can I do? Move 1 block on top of others
                                    start trying things I can do to find 
                                    
                                    learn on simpler challenges
                                    
        Options:
            inventGoal()
                    findGoalThatsOptimallyDiscrepant
                    moveBlock
            whichGoal=chooseGoal()
            workTowardGoal(whichGoal);
         * 
         */
    }
    
    void setGoal() {
        
        //set goal to optimally discrepant form of model <--- this is what fun is
//        goal=perception.perturb();
        //cool goes faster than possible
                
        goal=new int[rows][cols];
        goal[2][3]=1;
        goal[1][3]=3;
        goal[0][3]=2;
        
    }
    
    
    
    
    
    class HackerPanel extends JPanel {
        private final int[][] perception;
        public HackerPanel(int[][] perception) {
            super();
            this.perception=perception;
            
            setLayout(new GridLayout());
            
           // setSize((cols)*SCALE,rows*SCALE);

            
        }
        public void paint(Graphics g) {
           /* g.setColor(Color.yellow);
            g.fillRect(SCALE,getHeight()-SCALE, SCALE, SCALE);
            g.setColor(Color.blue);
            g.fillRect(3*SCALE,getHeight()-SCALE, SCALE, SCALE);
            g.setColor(Color.red);
            g.fillRect(3*SCALE,getHeight()-2*SCALE, SCALE, SCALE);
            */
                   
            g.setColor(Color.white);
            for(int i =0;i<rows;i++)
                for(int j =0;j<cols;j++) { 
                    if(perception[i][j]>0){
                        
                         g.setColor(COLORS[perception[i][j]]);
                         g.fillRect(j*SCALE+PADDING, getHeight()-(i+1)*SCALE-PADDING, SCALE, SCALE);
                    }
                    
                    g.setColor(Color.black);
                    g.drawRect(j*SCALE+PADDING, getHeight()-(i+1)*SCALE-PADDING, SCALE, SCALE);
                        
                }
                    
        }
    }

    
    class Mind {
        
        ArrayList<Gestalt> openGs;
        ArrayList<Ability> abilities;
        
        public Mind() {
            
        }
        
        void addGestalt(Gestalt g) {
            openGs.add(g);
        }
        
        void perceive(Percept p) {
            addGestalt(p);
        }

        void play() {
            
        }

        void wuji() {
            
        }
        
        void yinyang() {
            
        }

        void taiChi() {
            /*
            
            survey openGs -- tension systems
            take most graceful action
            
             */     
        }
        
    }
        
        
    class Model {
        
        
        public Model() {
            
        }
        
        void perceive(Percept p) {
            
        }
        
    }

   class BoolModel extends Model {
        
        public BoolModel() {
            
        }
        
        void perceive(boolean p) {
            
        }
        
    }
        
    class Ability {
        
        
        public Ability() {
            
        }
        
        void perceive(Percept p) {
            
        }
        
    }
        
    class Gestalt {
        
        public Gestalt() {
            
        }
        
        void perceive(Percept p) {
            
        }
    }
    
    class Percept extends Gestalt{
        
        public Percept() {
            
        }
        
        void perceive(Percept p) {
            
        }
    }
    
    class DeepGoal extends Gestalt {
        
        public DeepGoal() {
            
        }
        
        void perceive(Percept p) {
            
        }
    }
    
    
}

/*
 * 
 * brain
 *  percept
 *  model
 *  
 * 
 * CODE IS VISUALIZED PHILOSOPHY
 * CODE IS PHILOSOPHY GIVEN LIFE
 * 
 */