import java.util.ArrayList;            // by Harsh 05311502820 ECE1
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class CollegeProject {
  
    public static void printgame(char game[][]) {
        for(int i=0;i<5;i++){
               for( int j=0;j<5;j++){
                   System.out.print(game[i][j]);
               }
               System.out.println();
           }
        }
        public static void place(char game[][],int pos,String player,ArrayList<Integer> playerpos,ArrayList<Integer> cpupos) {
        char a=' ';
        
            if(player=="user"){a='X'; playerpos.add(pos); }
            
            else if(player=="cpuin") {a='O';cpupos.add(pos);}
          
            switch(pos){
                case 1: game[0][0]=a; break;
                case 2: game[0][2]=a; break;
                case 3: game[0][4]=a; break;
                case 4: game[2][0]=a; break;
                case 5: game[2][2]=a; break;
                case 6: game[2][4]=a; break;
                case 7: game[4][0]=a; break;
                case 8: game[4][2]=a; break;
                case 9: game[4][4]=a; break;
        
             }
		
        }



    static public String winner(ArrayList<Integer> playerpos,ArrayList<Integer> cpupos){ 
   
        List toprow=Arrays.asList(1,2,3);
        List midrow=Arrays.asList(4,5,6);
        List botrow=Arrays.asList(7,8,9);
        List rigcol=Arrays.asList(1,4,7);
        List midcol=Arrays.asList(2,5,8);
        List leftcol=Arrays.asList(3,6,9);
        List cross1=Arrays.asList(1,5,9);
        List cross2=Arrays.asList(3,5,7);
        List<List> win = new ArrayList<List>();
        win.add(toprow); win.add(midrow); win.add(botrow); win.add(rigcol); win.add(leftcol); win.add(midcol); win.add(cross1); win.add(cross2);
        for ( List l : win){
            if(playerpos.containsAll(l)){return " YOU WON";}
            else if (cpupos.containsAll(l)) {return "YOU LOST";}
            else if(playerpos.size()+cpupos.size()==9){ return " DRAW";}
        }
        
       

return "";
    }
    static public void main(String args[])
    { 	 
    	char[][] game= {{'1','|','2','|','3'},{'-','+','-','+','-'},{'4','|','5','|','6'},{'-','+','-','+','-'},{'7','|','8','|','9'}};
    printgame(game);
    
	Scanner input=new Scanner(System.in);
	
     ArrayList<Integer> playerpos=new ArrayList<Integer>();
    ArrayList<Integer> cpupos=new ArrayList<Integer>();
   while(true){
     
    System.out.print(" ENTER YOUR INPUT 1 to 9 :  ");

    int userin=input.nextInt(); 
    while(true){ if( userin<1 || userin >9)
        { System.out.println("WRONG INPUT!!  TAKE INPUT BETWEEN 1 AND 9");
            userin =input.nextInt(); }
            else { break;}

    }
    while(playerpos.contains(userin) || cpupos.contains(userin)){
       System.out.println("THIS POSITION IS ALREADY TAKEN: "); userin=input.nextInt();
    }
    place(game, userin, "user",playerpos,cpupos);
    String result =winner(playerpos, cpupos);
    if(result.length()>0)
    {
       printgame(game); System.out.println(result);  break;
    }
   
    Random j= new Random();
     int k=j.nextInt(9)+1;
     while(playerpos.contains(k)|| cpupos.contains(k))
     {k=j.nextInt(9)+1;}
     place(game,k,"cpuin",playerpos,cpupos);
      result =winner(playerpos, cpupos);
    if(result.length()>0)
    {  printgame(game);
        System.out.println(result); break;
    }
     
      printgame(game);}  }
    
}
