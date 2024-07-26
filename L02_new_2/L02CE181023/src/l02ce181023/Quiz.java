/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02ce181023;

import java.util.ArrayList;

/**
 * L02 quiz Bow
 *
 * @author Lam Tan Phat - CE181023
 */
public class Quiz {

    //Declare the variable
    private String questionTFAndSA;
    private String ansTFAndSA;

    private String questionMC;
    private String ansMC;
    private ArrayList<String> choiceMC = new ArrayList<>();

    private int pointTFAndSA;
    private int pointMC;

    /**
     * Default constructor for creating a Quiz object with default values.
     */
    public Quiz() {
    }

    /**
     * Parameterized constructor to initialize a Quiz object with specific
     * values.
     *
     * @param questionTFAndSA the question of TF and SA
     * @param ansTFAndSA the answer of TF and SA
     * @param pointTFAndSA the point of TF and SA
     */
    public Quiz(String questionTFAndSA, String ansTFAndSA, int pointTFAndSA) {
        this.questionTFAndSA = questionTFAndSA;
        this.ansTFAndSA = ansTFAndSA;
        this.pointTFAndSA = pointTFAndSA;
    }

    /**
     * Parameterized constructor to initialize a Quiz object with specific
     * values.
     *
     * @param questionMC the question of MC
     * @param ansMC the answer of MC
     * @param choiceMC the multiple choice of MC
     * @param pointMC the point of MC
     */
    public Quiz(String questionMC, String ansMC, ArrayList<String> choiceMC, int pointMC) {
        this.questionMC = questionMC;
        this.ansMC = ansMC;
        this.choiceMC = choiceMC;
        this.pointMC = pointMC;
    }

    /**
     * Get the question TF and SA of the Quiz
     *
     * @return the question TF and SA of the Quiz
     */
    public String getQuestionTFAndSA() {
        return questionTFAndSA;
    }

    /**
     * Set the question TF and SA of the Quiz.
     *
     * @param questionTFAndSA the question TF and SA of the Quiz
     */
    public void setQuestionTFAndSA(String questionTFAndSA) {
        this.questionTFAndSA = questionTFAndSA;
    }

    /**
     * Get the answer TF and SA of the Quiz
     *
     * @return the answer TF and SA of the Quiz
     */
    public String getAnsTFAndSA() {
        return ansTFAndSA;
    }

    /**
     * Set the answer TF and SA of the Quiz.
     *
     * @param ansTFAndSA the answer TF and SA of the Quiz
     */
    public void setAnsTFAndSA(String ansTFAndSA) {
        this.ansTFAndSA = ansTFAndSA;
    }

    /**
     * Get the question MC of the Quiz
     *
     * @return the question MC of the Quiz
     */
    public String getQuestionMC() {
        return questionMC;
    }

    /**
     * Set the question MC of the Quiz.
     *
     * @param questionMC the question MC of the Quiz.
     */
    public void setQuestionMC(String questionMC) {
        this.questionMC = questionMC;
    }

    /**
     * Get the answer MC of the Quiz
     *
     * @return the answer MC of the Quiz
     */
    public String getAnsMC() {
        return ansMC;
    }

    /**
     * Set the answer MC of the Quiz.
     *
     * @param ansMC the answer MC of the Quiz
     */
    public void setAnsMC(String ansMC) {
        this.ansMC = ansMC;
    }

    /**
     * Get the multiple choice the MC of the Quiz
     *
     * @return the multiple choice the MC of the Quiz
     */
    public ArrayList<String> getChoiceMC() {
        return choiceMC;
    }

    /**
     * Set the multiple choice MC of the Quiz.
     *
     * @param choiceMC the multiple choice MC of the Quiz
     */
    public void setChoiceMC(ArrayList<String> choiceMC) {
        this.choiceMC = choiceMC;
    }

    /**
     * Get the point TF and SA of the Quiz
     *
     * @return the point TF and SA of the Quiz
     */
    public int getPointTFAndSA() {
        return pointTFAndSA;
    }

    /**
     * Set the point TF and SA of the Quiz.
     *
     * @param pointTFAndSA the point TF and SA of the Quiz.
     */
    public void setPointTFAndSA(int pointTFAndSA) {
        this.pointTFAndSA = pointTFAndSA;
    }

    /**
     * Get the point MC of the Quiz
     *
     * @return the point MC of the Quiz
     */
    public int getPointMC() {
        return pointMC;
    }

    /**
     * Set the point MC of the Quiz.
     *
     * @param pointMC the point MC of the Quiz
     */
    public void setPointMC(int pointMC) {
        this.pointMC = pointMC;
    }

}
