import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Testing {

    /* define constants */
    static int numberOfTrials = 20;
    private static final int MAXSTRINGSIZE = 17000;
    static String ResultsFolderPath = "/home/elizabeth/Results/LCS/"; // pathname to results folder
    static FileWriter resultsFile;
    static PrintWriter resultsWriter;

    public static void main(String[] args) {

        boolean correct =  Verification.verification(OptimizedLCS::LCS);
        System.out.println("Verification Pass?: " + correct);
        if(correct) {
            // run the whole experiment at least twice, and expect to throw away the data from the earlier runs, before java has fully optimized
            runFullExperiment("BruteForceLCS-Exp1-ThrowAway.txt");
            runFullExperiment("BruteForceLCS-Exp2.txt");
            runFullExperiment("BruteForceLCS-Exp3.txt");
        }
    }

    private static void runFullExperiment(String resultsFileName) {
        String englishText1;
        String englishText2;
        try {
            resultsFile = new FileWriter(ResultsFolderPath + resultsFileName);
            resultsWriter = new PrintWriter(resultsFile);
            englishText1 = ReadTextAsString.readFileAsString("/home/elizabeth/Results/LCS/EnglishText/studyInScarlet.txt");
            englishText2 = ReadTextAsString.readFileAsString("/home/elizabeth/Results/LCS/EnglishText/houndOfBaskervilles.txt");
        } catch (Exception e) {
            System.out.println("*****!!!!!  Had a problem opening the results file " + ResultsFolderPath + resultsFileName);
            return;
        }

        ThreadCpuStopWatch BatchStopwatch = new ThreadCpuStopWatch(); // for timing an entire set of trials
        ThreadCpuStopWatch TrialStopwatch = new ThreadCpuStopWatch(); // for timing an individual trial
        double lastAverageTime = -1;
        double doublingRatio = 0;

        resultsWriter.println("#String size)  AverageTime"); // # marks a comment in gnuplot data
        resultsWriter.flush();

        for (int inputSize = 1; inputSize <= MAXSTRINGSIZE; inputSize*=2) {
            System.out.println("Running test for string size " + inputSize + " ... ");
            System.out.print("    Running trial batch...");
            System.gc();
            long batchElapsedTime = 0;
            for (long trial = 0; trial < numberOfTrials; trial++) {
                System.out.print("    Generating test data...");
                //String s1 = randomStringOfSize(inputSize);
                //String s2 = randomStringOfSize(inputSize);
                String s1 = englishTextStringOfSize(inputSize, englishText1);
                String s2 = englishTextStringOfSize(inputSize, englishText2);
                System.gc();
                System.out.println("...done.");
                TrialStopwatch.start();
                String result = BruteForceLCS.LCS(s1,s2).substring;
                batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                System.out.println(s1);
                System.out.println(s2);
                System.out.println(result);
            }
            double averageTimePerTrialInBatch = (double) batchElapsedTime / (double) numberOfTrials; // calculate the average time per trial in this batch
            if (lastAverageTime != -1) {
                doublingRatio = averageTimePerTrialInBatch / lastAverageTime;
            }
            lastAverageTime = averageTimePerTrialInBatch;

            /* print data for this size of input */
            resultsWriter.printf("%12d  %15.2f %10.2f\n", inputSize, averageTimePerTrialInBatch, doublingRatio);
            resultsWriter.flush();
            System.out.println(" ....done.");
        }
    }

    //Returns a random string of the specified size
    //https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    public static String randomStringOfSize(int size){
        // lower limit for LowerCase Letters
        int lowerLimit = 97;

        // lower limit for LowerCase Letters
        int upperLimit = 122;

        Random random = new Random();

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(size);

        for (int i = 0; i < size; i++) {

            // take a random value between 97 and 122
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));

            // append a character at the end of bs
            r.append((char)nextRandomChar);
        }

        // return the resultant string
        return r.toString();
    }

    //tip: choose a random start index for the substring between 0 and bookString.Length() - N
    public static String englishTextStringOfSize(int size, String str){
        int lowerLimit = 0;
        int upperLimit = str.length()-size;

        Random random = new Random();
        int index = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
        return str.substring(index, index+size);
    }
}
