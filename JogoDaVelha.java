//1. Adicione um botão ao jogo que permite reiniciá-lo, apagando todas as jogadas.
//2. Adicione  um botão ao jogo que, quando clicado,  faz uma jogada com o jogador da vez,escolhendo uma casa aleatória que esteja vazia.

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
 public class JogoDaVelha
 {


    public static void main(String[] args) 
    {
       JFrame ticTacToe = new JogoDaVelhaFrame();
        ticTacToe.setTitle("Phantom TicTacToe Game!");
        ticTacToe.setSize(600, 600);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);  
    }

}
 class JogoDaVelhaFrame extends JFrame implements ActionListener 
{

   private char whoseTurn = 'X';
   private boolean gameOver = false;


   private Cell[][] cells = new Cell[3][3];


   JLabel jlblStatus = new JLabel("X's turn to play");


   public JogoDaVelhaFrame()
   {
       JButton btn = new JButton("Reset");
       JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
       for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
               panel.add(cells[i][j] = new Cell());


       add(btn, BorderLayout.SOUTH);
       add(panel, BorderLayout.CENTER);
       add(jlblStatus, BorderLayout.NORTH);
       jlblStatus.setOpaque(true);
       jlblStatus.setBackground(Color.YELLOW);
   }


    public boolean isFull()
    {
       for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
               if (cells[i][j].getToken() == ' ')
                   return false;
       return true;
    }


   public boolean vencedor(char token)
   {

       for (int i = 0; i < 3; i++)
           if ((cells[i][0].getToken() == token)
                   && (cells[i][1].getToken() == token)
                   && (cells[i][2].getToken() == token)) 
           {
               return true;
           }


       for (int j = 0; j < 3; j++)
           if ((cells[0][j].getToken() == token)
               && (cells[1][j].getToken() == token)
               && (cells[2][j].getToken() == token))
           {
               return true;
           }

       if ((cells[0][0].getToken() == token)
               && (cells[1][1].getToken() == token)
               && (cells[2][2].getToken() == token))
           {
               return true;
           }

       if ((cells[0][2].getToken() == token)
               && (cells[1][1].getToken() == token)
               && (cells[2][0].getToken() == token))
           {
               return true;
           }

       return false;
   }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton bttn = (JButton) e.getSource();
        if(bttn == btn)
        {

        }
    }


    public class Cell extends JPanel
    {

       private char token = ' ';


       public Cell()
       {
           setBorder(new LineBorder(Color.black, 1));
           addMouseListener(new MyMouseListener());
       }


       public char getToken()
       {
           return token;
       }


       public void setToken(char c)
       {
           token = c;
           repaint();
       }

       @Override
       protected void paintComponent(Graphics g)
       {
           super.paintComponent(g);

           if (token == 'X')
           {
               g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
               g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
           }

           else if (token == 'O')
           {
               g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
           }
       }

       private class MyMouseListener extends MouseAdapter
       {
           @Override
           public void mouseClicked(MouseEvent e)
           {
               if (gameOver)
                   return;


               if (token == ' ' && whoseTurn != ' ')
                   setToken(whoseTurn);


               if (vencedor(whoseTurn))
               {
                   jlblStatus.setText(whoseTurn + " won! Game over!");
                   whoseTurn = ' ';
                   gameOver = true;
               }
               else if (isFull())
               {
                   jlblStatus.setText("Tie game! Game over!");
                   whoseTurn = ' ';
                   gameOver = true;
               }
               else
               {
                   whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                   jlblStatus.setText(whoseTurn + "'s turn.");
               }
           }

       } 
    } 
    
  //1-Adicione um botão ao jogo que permite reiniciá-lo, apagando todas as jogadas.
    public void reiniciar() {
    JFrame JogoDaVelha = new JogoDaVelhaFrame();
    JogoDaVelha.setTitle("Phantom TicTacToe Game!");
    JogoDaVelha.setSize(600, 600);
    JogoDaVelha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JogoDaVelha.setLocationRelativeTo(null);
    JogoDaVelha.setVisible(true);
} 

 
 //Adicione  um botão ao jogo que, quando clicado,  faz uma jogada com o jogador da vez,escolhendo uma casa aleatória que esteja vazia.
 
    public class CasaAleatoriaArray {
        int size;
        int[] array;

    
    public CasaAleatoriaArray(int size) {
        this.size = size;
        array = new int[size];
        for (int i = 0; i<size; i++) {
            array[i] = i+1;
        }
    }

    
    public int remove() {
        int ans = -1;
        if (size > 0) {
            
            int randomNum = (int)(Math.random()*size);
            ans = array[randomNum];
 
            array[randomNum] = array[size-1];
            size--;
        }
        return ans;
    }
    }
}