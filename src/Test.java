
import java.io.IOException;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arun
 */
public class Test {
     
    
    public static void main(String arg[]) throws IOException, Exception, Throwable {
     String vowels = "৳ অরুণ বিশ্বাস  ";
    String consonants = "కఖగఘఙచఛజఝఞటఠడఢణతథదధనపఫబభమయరఱలళవశషసహ";
    String signsAndPunctuations = "కఁకంకఃకాకికీకుకూకృకౄకెకేకైకొకోకౌక్కౕకౖ";
    String symbolsAndNumerals = "౦౧౨౩౪౫౬౭౮౯";
    String engChinesStr = "ABC導字會";

//0980-09FF 
    Pattern ALPHANUMERIC_AND_SPACE_PATTERN_TELUGU = Pattern
            .compile("[ [\\u0980-\\u09E5] | [\\u09F0-\\u09FF] ]*+");
    System.out.println(ALPHANUMERIC_AND_SPACE_PATTERN_TELUGU.matcher(vowels)
            .matches());


    Pattern ALPHANUMERIC_AND_SPACE_PATTERN_CHINESE = Pattern
            .compile("[a-zA-Z0-9 \\u4e00-\\u9fff]*+");

    Pattern ENGLISH_ALPHANUMERIC_SPACE_AND_NLS_PATTERN = Pattern
            .compile("[a-zA-Z0-9 \\u0080-\\u9fff]*+");

    System.out.println(ENGLISH_ALPHANUMERIC_SPACE_AND_NLS_PATTERN.matcher(engChinesStr)
            .matches());
            

    }
    
}
