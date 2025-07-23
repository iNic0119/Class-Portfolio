package unit13.hangman;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;
import unit13.hangman.Hangman.Status;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangmanSolver implements Configuration<HangmanSolver>{
    private Hangman current;
    private String[] guesses;
    private String[] alphabet;

    public HangmanSolver(Hangman current, String[] guessesArr){
        this.current = current;
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        alphabet = a.split(" ");

        guesses = guessesArr;




    }

    @Override
    public Collection<HangmanSolver> getSuccessors(){
        ArrayList<HangmanSolver> successors = new ArrayList<>();
        ArrayList<Character> potentialGuesses = new ArrayList<>();

        int index=0;
        Arrays.sort(guesses);

        for(int i=0;i<alphabet.length;i++){
            if(guesses[index].equals(alphabet[i])){
                index++;
            }else{
                potentialGuesses.add(alphabet[i].charAt(0));
            }
        }

        for(char letter : potentialGuesses){
            Hangman dummy = new Hangman(current);
            String[] copy = Arrays.copyOf(guesses, guesses.length+1);

            dummy.guess(letter);
            copy[copy.length-1] = String.valueOf(letter);

            successors.add(new HangmanSolver(dummy, copy));
        }

        return successors;
    }

    @Override
    public boolean isValid(){
        return current.getStatus()!=Status.LOST;
    }

    @Override
    public boolean isGoal(){
        return current.getStatus()==Status.WON;
    }

    @Override
    public String toString(){
        return current.getGuesses()+" "+current.revealed();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = "";

        System.out.println("Enter a phrase: ");
        input = console.nextLine();

        Hangman hangman = new Hangman(input);

        String[] guesses = hangman.getGuesses().split(" ");

        HangmanSolver config = new HangmanSolver(hangman, guesses);

        Backtracker<HangmanSolver> backtracker = new Backtracker<>(true);
        backtracker.solve(config);

        config.toString();

        console.close();

    }

}
