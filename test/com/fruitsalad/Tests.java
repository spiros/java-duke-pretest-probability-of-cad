package com.fruitsalad;

import static org.junit.Assert.*;
import org.junit.Test;

import com.fruitsalad.DukePretestProbability;

public class Tests {
    
    @Test
    public void someTests(){
        
        double ptp = DukePretestProbability.calculateDukePretestProbability( 
                80, 
                1,
                0,
                false,
                false,
                false,
                false,
                false,
                false
                );
        
        assertEquals( 0.83, ptp, 0.05);
        
        double ptp2 = DukePretestProbability.calculateDukePretestProbability( 
                80, 
                2,
                0,
                false,
                false,
                false,
                false,
                false,
                false
                );
        
        assertEquals( 0.24, ptp2, 0.05);
        
        double ptp3 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                2,
                1,
                false,
                false,
                false,
                false,
                false,
                false
                );
        
        assertEquals( 0.20, ptp3, 0.05);
        
        double ptp4 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                1,
                1,
                false,
                false,
                false,
                false,
                false,
                false
                );
        
        assertEquals( 0.57, ptp4, 0.05);

        double ptp5 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                1,
                1,
                true,
                true,
                true,
                false,
                false,
                false
                );
        
        assertEquals( 0.92, ptp5, 0.05);

        double ptp6 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                1,
                1,
                false,
                false,
                false,
                true,
                true,
                true
                );
        
        assertEquals( 0.98, ptp6, 0.05);

        double ptp7 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                2,
                1,
                false,
                false,
                false,
                true,
                true,
                true
                );
        
        assertEquals( 0.90, ptp7, 0.05);

        double ptp8 = DukePretestProbability.calculateDukePretestProbability( 
                45, 
                1,
                2,
                false,
                false,
                false,
                false,
                false,
                false
                );
        
        assertEquals( 0.21, ptp8, 0.05);

        
        
    }
    
}


