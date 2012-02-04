package com.fruitsalad;

/*
 * DukePretesProbability.java
 * Purpose: calculate the Duke pre-test probability of coronary artery disease.
 * More information on the science behind this can be located from the following
 * paper: http://1.usa.gov/w16hE9
 * 
 * 
 * @author Spiros Denaxas
 * @version 1.0
 * 
 */

public class DukePretestProbability {
    
    private static double ptp;
    
    /*
     * Calculates the Duke pre-test probability of coronary artery disease.
     * 
     * @param age Patients age
     * @param sex Patient's sex, 1 for male and 2 for female
     * @param chestPain Typicality of presenting chest pain, 0 for none, 1 for typical and 2 for atypical
     * @param smokingStatus Patients smoking status, 1 for smoker and 0 for non smoker
     * @param diabetesStatus Is the patient a diabetic, 1 for yes
     * @param hyperlipidaemiaStatus Does the patient suffer from hyperlipidaemia, 1 for yes
     * @param previousMI Has the patient had a previous MI, 1 for yes
     * @param ecgQwave ECG Q waves from previous MI present? 1 for yes
     * @param ecgSTchanges ST changes at rest? 1 for yes
     * 
     */
    
    public static double calculateDukePretestProbability( 
            float    age,
            int  sex,
            int  chestPain,
            boolean  smokingStatus,
            boolean  diabetesStatus,
            boolean  hyperlipidaemiaStatus,
            boolean  previousMI,
            boolean  ecgQwave,
            boolean  ecgSTchanges ){
        
        int formulaSex             = 0;
        int formulaTypicalCP       = 0;
        int formulaAtypicalCP      = 0;
        int formulaSmoking         = 0;
        int formulaDiabetes        = 0;
        int formulaHyperlipidaemia = 0;
        int formulaPreviousMI      = 0;
        int formulaQwave           = 0;
        int formulaSTchanges       = 0;
        
        double baseline     = 0;
        double riskFactors  = 0;
        double interactions = 0;
        double rawScore     = 0;
        double intercept    = -7.376;
        
        // Patient sex
        if ( sex == 1 ){
            formulaSex = 0;
        } else {
            formulaSex = 1;
        }
        
        // Chest pain typicality
        
        if ( chestPain == 1 ){
            formulaTypicalCP = 1;
            formulaAtypicalCP = 0;
        } else if ( chestPain == 2 ){
            formulaTypicalCP = 0;
            formulaAtypicalCP = 1;
        }
        
        // Diabetes
        
        if ( diabetesStatus == true ){
            formulaDiabetes = 1;
        }
        
        // Hyperlipidaemia
        
        if ( hyperlipidaemiaStatus == true) {
            formulaHyperlipidaemia = 1;
        }
        
        // Smoking
        
        if ( smokingStatus == true ){
            formulaSmoking = 1;
        }
        
        // previous MI
        
        if ( previousMI == true ){
            formulaPreviousMI = 1;
        }
        
        // ECG 
    
        if ( ecgQwave == true ){
            formulaQwave = 1;
        }
        
        if ( ecgSTchanges == true){
            formulaSTchanges = 1;
        }
        
        baseline =
            ( age               * 0.1126 ) +
            ( formulaSex        * -0.328 ) +
            ( formulaTypicalCP  * 2.581  ) +
            ( formulaAtypicalCP * 0.976  ) +
            ( formulaQwave      * 1.213  ) +
            ( formulaSTchanges  * 0.673  ) +
            ( formulaPreviousMI * 1.093  );
        
        riskFactors = 
            formulaSmoking         * 2.596 +
            formulaDiabetes        * 0.694 +
            formulaHyperlipidaemia * 1.845;

        interactions = 
            ( age               * formulaSex             * -0.0301 ) +
            ( formulaPreviousMI * formulaQwave           *  0.741  ) +
            ( age               * formulaSmoking         * -0.0404 ) +
            ( age               * formulaHyperlipidaemia * -0.0251 ) +
            ( formulaSex        * formulaSmoking         *  0.55   );

        rawScore = intercept + baseline + riskFactors + interactions;
        
        ptp = 1 / ( 1 + Math.pow( Math.exp(1.0), rawScore * -1  ) );
        
        return ptp;
        
    }
    
}
