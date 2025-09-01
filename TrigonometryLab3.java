/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trigonometrylab3;
import java.util.Scanner;
import static java.lang.Math.*;
import java.util.InputMismatchException;

/**
 *
 * @author Student
 */
public class TrigonometryLab3 {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            System.out.println("Problem 1: Trigonometric Function Calculator");
            System.out.println("Please input an angle in degrees.");
            double angle1=input.nextDouble();
        
                System.out.println("Please choose a function.");
                System.out.println("1: Sine");
                System.out.println("2: Cosine");        
                System.out.println("3: Tangent");
                System.out.println("4: All three trigonometric functions");
                int choice1 = input.nextInt();
                
                double angle1rad=toRadians(angle1);
                double sine1 = sin(angle1rad);
                double cosine1 = cos(angle1rad);
                double tangent1 = tan(angle1rad); //gi define lang nako daan para dili nako mag balik balik and i can just use the already named variables
                
                    if ( choice1==1 || choice1==4 ) {
                        System.out.println("Its value in Sine is " + sine1 + ".");
                    } if ( choice1==2 || choice1==4 ) {
                        System.out.println("Its value in cosine is " + cosine1 + ".");
                    } if ( choice1==3 || choice1==4 ) {  
                            if (abs(angle1%180) ==90 ) { //gigamitan nako ni diriag modulo operator para mahibal an ang remainder if angle1 divided by 180 is 90. Since 90 over 180 leaves a remainder of 90 and 270 over 180 also leaves a remainder of 90.
                                System.out.println("The value in Tangent of " + angle1 + " degrees is undefined since it is a multiple of 180 that started at 90.");
                            } else {
                                System.out.println("Its value in Tangent is " + tangent1 + ".");
                            }//kani tanan kay gigamitan nakog logical OR operator. Pwede ragud dili pero if dili ko mag gamit ana na operator kay i would need to repeat sa else if for choice 4
                    } else {
                        System.out.println("Please choose 1-4 only.");
                        input.nextLine();
                    }         
                   
        
                        //Critical Thinking Questions
                    
                    //1. Why do we need to convert angles from degrees to radians?
                        //We need to convert the angle from degree to radians because the programming language Math.lang uses radians to perform calculations. It uses radians because it is related to the geometry of the circle.
                    //2. What makes tangent undefined at certain angles?
                        //Tangent is undefined at certain angles like 90, 270, and 450 (basically start sa 90, and add 180 to get values where tan is undefined) because tangent(theta) = sin(theta) / cos(theta). Since 0 ang cos for every 90 + 180^n equation, the denominator becomes 0, which makes it undefined.
                    //3. How could you modify this program to also calculate reciprocal functions?
                        //Mag add kag more choices una then more if-else statements, and just use 1.0/sin(angle1rad) for cosecant, 1.0 / cos(angle1rad) for secant, and 1.0 / tan(angle1rad) for cotangent.
                    
                    
            System.out.println("Problem 2: Angle Quadrant Detector");
        try {    
            System.out.println("Please input an angle in degrees.");
            double angle2=input.nextDouble();
                
                double normalization = angle2 % 360; //a value between 0 and 360 degrees
                
                    if (normalization <0) { //buhatan nato ani kay since nag gamit man tag modulus operator and 360, the new value would lie between 0-360 and if negative ang value then we add 360, ma abot sya sa tama na quadrant.
                        normalization += 360; //diri ta nag add ug 360 kay para ma padulong sa tama na quadrant(tao) 
                    }
                    
                    //diri kay we solve for what quadrant it lies on since na solve na nato ang problema with negative angles
                    String quadrant = null; //i string nato ang quadrant daan so we can just substitute it later para mas dali.
                    if (normalization > 0 && normalization < 90 ) { //angles that lie on quadrant 1 ranges from 1-89
                        quadrant="Quadrant 1.";
                    } else if (normalization > 90 && normalization < 180) { //angles that lie on quadrant 2 ranges from 91-179
                        quadrant="Quadrant 2.";
                    } else if (normalization > 180 && normalization < 270) { //angles that lie on quadrant 3 ranges from 181-269
                        quadrant="Quadrant 3.";
                    } else if (normalization > 270 && normalization < 360) { //angles that lie on quadrant 4 ranges from 271-359
                        quadrant="Quadrant 4.";
                    } else if ( normalization == 0 ) { //angles that lie on quadrant 4 ranges from 271-359
                        quadrant="the positive x-axis.";
                    } else if ( normalization == 90 ) { //angles that lie on quadrant 4 ranges from 271-359
                        quadrant="the positive y-axis.";
                    } else if ( normalization ==180 ) { //angles that lie on quadrant 4 ranges from 271-359
                        quadrant="the negative x-axis.";
                    } else if ( normalization == 270 ) { //angles that lie on quadrant 4 ranges from 271-359
                        quadrant="the negative y-axis.";
                    }             
                    String signofsin = null;
                    String signofcos = null;
                    String signoftan = null; // same ra sa gibuhat nato sa quadrant, we are using string para mas musayon.
            switch (quadrant) {
                case "Quadrant 1.":
                    //originally mag gamit unta kog "quadrant==("Quadrant 1.")" para depende sa kung unsa ang output sa quadrant pero nag recommend ang IDE na i quadrant.equals daw so mao nalang akong gigamit
                    signofsin = "positive.";
                    signofcos = "positive.";
                    signoftan = "positive.";
                    break;
                case "Quadrant 2.":
                    signofsin = "positive.";
                    signofcos = "negative.";
                    signoftan = "negative.";
                    break;
                case "Quadrant 3.":
                    signofsin = "negative.";
                    signofcos = "negative.";
                    signoftan = "positive.";
                    break;
                case "Quadrant 4.":
                    //para ani sa ila gi check nako gamit 89, 91, 181, and 359 respectively to check for signs for quadrant 1, 2, 3, and 4.
                    signofsin = "negative.";
                    signofcos = "positive.";
                    signoftan = "negative.";
                    break;
                case "the positive x-axis.":
                    //para ani sa ila gi check nako gamit 89, 91, 181, and 359 respectively to check for signs for quadrant 1, 2, 3, and 4.
                    signofsin = "no sign(0).";
                    signofcos = "positive.";
                    signoftan = "no sign(0).";
                    break;
                case "the positive y-axis.":
                    //para ani sa ila gi check nako gamit 89, 91, 181, and 359 respectively to check for signs for quadrant 1, 2, 3, and 4.
                    signofsin = "positive.";
                    signofcos = "no sign(0)."; 
                    signoftan = "undefined.";
                    break;
                case "the negative x-axis.":
                    //para ani sa ila gi check nako gamit 89, 91, 181, and 359 respectively to check for signs for quadrant 1, 2, 3, and 4.
                    signofsin = "no sign(0).";
                    signofcos = "negative.";
                    signoftan = "no sign(0).";
                    break;
                case "the negative y-axis.":
                    //para ani sa ila gi check nako gamit 89, 91, 181, and 359 respectively to check for signs for quadrant 1, 2, 3, and 4.
                    signofsin = "negative.";
                    signofcos = "no sign(0).";
                    signoftan = "Undefined.";
                    break;
                default:
                    break;
            }
                    
                        System.out.println("The angle " + angle2 + " in degrees lies on " + quadrant); //we are now printing the results for everything sa problem 2
                        System.out.println("Its sign in sine is: " + signofsin);
                        System.out.println("Its sign in cosine is: " + signofcos);
                        System.out.println("Its sign in tangent is: " + signoftan);
        } catch (InputMismatchException e) {
            System.out.println("Please use numbers for the values.");
            input.nextLine();
        }            
                     
        
                        //Critical Thinking Questions
                        
                    //1. Why is it important to normalize angles before determining their quadrant?
                        // We need to normalize the angle because trigonometric functions are periodic, which means na naga repeat sila every 360. An example is 720 degrees. Mathematically speaking, same ra sila sa 360 degrees or 0. It isnt necessary to normalize angles pero it gives u a fixed range (0-360).
                    //2. How does the sign of trigonometrc functions change across different quadrants?
                        // For Quadrant 1, sin, cos, and tangent is positive. For Quadrant 2, only sin is positive while cos and tan is negative. For Quadrant 3, only tan is positive, while sin and cos is negative. For Quadrant 4, only cos is positive, while sin and tan is negative.
                    //3. What special considerations are needed for angles exactly on the axes?
                        // Since ang mga values na naa sa axis doesnt belong to any quadrant. Pwede ma undefined ang tan, sec, cot, and csc.
                     
                    
            System.out.println("Problem 3: Right Triangle Solver");
            try {
            System.out.println("What elements are present in the right triangle?");
            System.out.println("1. Two sides.");
            System.out.println("2. One side and an angle.");
            int elements = input.nextInt();
                
                double angleC = 90;
                double sideA = 0, sideB = 0, sideC = 0; // basically we are making a string pero gitagaan sa natog value daan
                double angleA = 0, angleB = 0; // same here but for the angles instead
            switch (elements) {
                case 1:
                    //if elements is 1
                    
                    System.out.println("What is the first side present?");
                    System.out.println("a");
                    System.out.println("b");
                    System.out.println("c");
                    char side1=input.next().charAt(0);
                    System.out.println("What is its length?");
                    double side1value=input.nextDouble();
                    System.out.println("What is the second side present?");
                    System.out.println("a");
                    System.out.println("b");
                    System.out.println("c");
                    char side2=input.next().charAt(0); //we use letters diria kay common ra kaayo sigeg double hahaha
                    System.out.println("What is its length?");
                    double side2value=input.nextDouble();
                switch (side1) {
                    case 'A':
                    case 'a':
                        //depende kung unsa na side ang given sa side 1 nato
                        sideA = side1value;
                        break;
                    case 'B':
                    case 'b':
                        sideB = side1value;
                        break;
                    case 'C':
                    case 'c':
                        //gamit ang kaning tulo kay gitagaan natog value ang side 1 dependent kung unsa sya na side ang given
                        sideC = side1value;
                        break;
                    default:
                        break;
                }
                switch (side2) {
                    case 'A':
                    case 'a':
                        //same ra diria sa side 2
                        sideA = side2value;
                        break;
                    case 'B':
                    case 'b':
                        sideB = side2value;
                        break;
                    case 'C':
                    case 'c':
                        //same ra diria sa taas
                        sideC = side2value;
                        break;
                    default:
                        break;
                }
                    if ( sideA > 0 && sideB >0 ) {
                        sideC = sqrt( pow(sideA,2) + pow(sideB,2) ); //if side A and B ang given, the formula to be used will be C^2 = A^2 + B^2
                        angleA = toDegrees(atan( sideA / sideB )); //nag gamit ko dirig inverse trigonometric functions which is arctan sideA over side B
                        angleB = toDegrees(atan( sideB / sideA ));
                    } else if ( sideA > 0 && sideC >0 ) {
                        sideB = sqrt( pow(sideC,2) - pow(sideA,2) );// if side A and C ang given, the formula to be used will be B^2 = C^2 - A^2
                        angleA = toDegrees(atan( sideA / sideC ));
                        angleB = toDegrees(atan( sideA / sideC ));
                    } else if ( sideB > 0 && sideC >0 ) {
                        sideA = sqrt( pow(sideC,2) - pow(sideB,2) );// if side B and C pud ang given, the formula to be used will be A^2 = C^2 - B^2
                        angleA = toDegrees(atan( sideB / sideC ));
                        angleB = toDegrees(atan( sideB / sideC ));
                    }
                    break;


                case 2:
                    //if the choice chosen was 2
                    
                    System.out.println("What side is given?");
                    System.out.println("a");
                    System.out.println("b");
                    System.out.println("c");
                    char sideelements=input.next().charAt(0);
                    System.out.println("What is its length?");
                    double sideelementsvalue=input.nextDouble();
                    System.out.println("What is the value of the given angle in degrees? (Must be an angle less than 90)");
                    double angleelementsdeg = input.nextDouble();
                    if ( angleelementsdeg<=0 || angleelementsdeg>=90 ) {
                        System.out.println("Angle must be between 0-90 degrees. (Excluding 90 degrees)");
                        input.nextLine();
                    }
                switch (sideelements) { 
                    case 'A':
                    case 'a':
                        //depende kung unsa na side ang given sa side 1 nato,same sa taas
                        sideA = sideelementsvalue;
                        angleA = angleelementsdeg;
                        break;
                    case 'B':
                    case 'b':
                        sideB = sideelementsvalue;
                        angleB = angleelementsdeg;
                        break;
                    case 'C':
                    case 'c':
                        //gamit ang kaning tulo kay gitagaan natog value ang side 1 dependent kung unsa sya na side ang given
                        sideC = sideelementsvalue;
                        if ( angleelementsdeg== angleA ) {
                            angleA = angleelementsdeg;
                        } else if ( angleelementsdeg== angleB ){
                            angleB = angleelementsdeg;
                        }
                        break;
                    default:
                        break;
                }
                    break;

                default:
                    System.out.println("Please type 1 or 2.");
                    input.nextLine();
                    break;
            }
                    
                        if ( angleA>0 && angleB == 0 ) {
                            angleB = 90 - angleA; //ang pulos ani is to find the other angle. Since and duha ka angle in a right triangle equals to 90, then that would mean kung pila ang value sa isa ka side, i minus lang nimo sa 90 para makuha nimo ang iyang value.
                        } else if ( angleB>0 && angleA == 0 ) {
                            angleA = 90 - angleB;
                        }
                        
                    if ( sideA > 0 && angleA > 0 ) { //kung ang given kay sideA ug angleA
                        sideB = sideA / tan(toRadians(angleA)); //formula sa sideB kay sideA/tangent(angleA)
                        sideC = sideA / sin(toRadians(angleA)); //formula sa sideC kay sideA/sine(angleA)
                    }  else if ( sideB > 0 && angleB > 0 ) { // kung ang given kay sideB and angleB
                        sideA = sideB / tan(toRadians(angleB)); //sideA = sideB/tan(angleB)
                        sideC = sideB / sin(toRadians(angleB)); //sideC = sideB/sin(angleB)
                    }   else if ( sideC > 0 && angleA > 0 ) { // kung ang given kay side C and angleA
                        sideA = sideC / sin(toRadians(angleA)); //sideA = sideC / sin(angleA)
                        sideB = sideC / cos(toRadians(angleA)); // sideB = sideC / cos(angleA)
                    }   else if ( sideC > 0 && angleB > 0 ) { // kung ang given kay sideC and angleB
                        sideA = sideC / cos(toRadians(angleB)); // sideA = sideC / cos(angleB)
                        sideB = sideC / sin(toRadians(angleB)); // sideB = sideC / sin(angleB)
                    } // using these lines of code, naa natay value sa tanan sides, which depend kung unsay given and assign values to the missing ones.
                    
                        //para ni sa area
                        double areaofrighttriangle = (sideA*sideB) / 2;
                    
                System.out.println("Side A: " + sideA);
                System.out.println("Side B: " + sideB);
                System.out.println("Side C (Hypotenuse): " + sideC);
                System.out.println("Angle A: " + angleA);
                System.out.println("Angle B: " + angleB);
                System.out.println("Angle C: " + angleC);
                System.out.println("Area: " + areaofrighttriangle); 
                       
            } catch (InputMismatchException e) {
                System.out.println("Please input numbers for the angles and lengths.");
                input.nextLine();
            } 
            
            
                        //Critical Thinking Questions
                        
                    //1. Why must we validate that angles in a right triangle are less than 90?
                        // Because angleC is always 90 degrees. If the sum of all angles in a triangle is 180, that would mean that the other two angles, if combined, should be equal to 90. Kay if more than 90 ang isa ka angle, then the triangle does not exist.
                    //2. How does your program handle the different cases of known values?
                        // nag if-else ko for the choice, which uses a double type for values 1 and 2 only. for choice 1, gina compare lang nako sila. Then it usese th epythagorean theorem
                    //3. What would happen if a user entered values that dont form a valid right triangle?
                        // In my code, it would show ang value sa side na imong gitagaan ug value and show angleC with an angle of 90, since in a right triangle kay 90 always ang anglec.
                    
            
            System.out.println("Problem 4: Trigonometric Identity Verifier");
            try {
                System.out.println("Please input an angle in degrees.");
                double trigangle=input.nextDouble();
                
                double triganglerad=toRadians(trigangle);//we convert the angle to radians
                double tolerance=1e-9;//basically 1*10^-9  & we are using a small tolerance para sa floating-point comparisons to handle inaccuracies 
                
                    System.out.println("Verifying the trigonometric identities for " + trigangle + " degrees.");
                
                        //Identity 1 ni 
                        double sinTheta = sin(triganglerad);
                        double cosTheta = cos(triganglerad);
                        double leftside1 = pow(sinTheta,2)  + pow(cosTheta,2);
                        double rightside1 = 1.0;
                        double difference1 = abs(leftside1 - rightside1);
                        System.out.print("Identity 1 is: ");
                        
                        if ( tolerance > difference1 ) { //since we need to prove nga equal sila, if 1e-9 is bigger than difference1(which is 0 dapat if true), then that would mean nga the identity is true
                            System.out.println("True (the identity is true)");
                        } else {
                            System.out.printf("False (the difference is %.15f)\n", difference1); //mag line break lang ta and we used printf since naa man tay value and it automatically assigns that value and this is basically simplifying
                        }
                        
                        //Identity 2 ni
                        if ( abs(cosTheta) < tolerance ) {
                            System.out.print("Identity 2 is: ");
                            System.out.println("Undefined (because tangent and secant is undefined at " + trigangle+ " degrees).");
                        } else {
                            double tanTheta = tan(triganglerad);
                            double secTheta = 1.0 / cosTheta;
                            double leftside2 = 1.0 + pow(tanTheta,2);
                            double rightside2 = pow(secTheta,2);
                            double difference2 = leftside2 - rightside2;
                            System.out.print("Identity 2 is: ");
                                if ( tolerance > difference2 ) {
                                    System.out.println("True (the identity is true)");
                                } else {
                                    System.out.printf("false (the difference is %.15f)\n", difference2);
                                }
                        }
                        
                        //Identity 3 ni
                        double leftside3 = sin( 2 * triganglerad);
                        double rightside3 = 2 * sinTheta * cosTheta;
                        double difference3 = leftside3 - rightside3;
                        System.out.print("Identity 3 is: ");
                            if ( tolerance > difference3 ) {
                                System.out.println("True (the identity is true)");
                            } else {
                                System.out.printf("False (the difference is %.15f)\n", difference3);
                            }
                        //basically ang gibuhat nako sa 3 ka identities kay gi tagaan nakog iyahang variable for each identities' left side and right side respectively.
            } catch (InputMismatchException e) {
                System.out.println("Please use numbers for the values.");
                input.nextLine();
            }
            
            
                        //Critical Thinking Questions
                        
                    //1. Why do we need a tolerance when comparing floating-point values?
                        // We need a tolerance because computers represent the complete value jud. For example, decimals that are infinitely repeating, an equation nga nag equal ug 0.0001010101010001..... If mag compare ta ug duha ka values, even though it looks like it doesnt have a difference at the start, there could be a slight difference sa pinakaiwit sa value which makes it not equal so dili ka pwede mag gamit ug equal(=) lang, which makes the comparison wrong even though it is right at a certain point.
                    //2. Which identity might be most susceptible to floating-point precision issues and why? 
                        //Identity 1. Since lahi-lahi silag calculations, sa pag round-off, pwede mag represent ug very minimal rounding errors. If i add nimo ang sin2theta and cos2theta, the number could be close to 1 pero dili 1 itself.
                    //3. How could you extend this program to verify more complex identities?
                        // For this program to verify more complex identities, we can still use the tolerance value for comparing the value at a more accurate point. Just copy the given identity, isolate the left side and right side, and use the tolerance value to compare whether the given value is true or false.
            
            
            System.out.println("Problem 5: Wave Properties Analyzer");
            try {
                System.out.println("Please input amplitude(A) of the wave.");
                double amplitude = input.nextDouble();
                
                System.out.println("Please input frequency(f in hertz) of the wave.");
                double frequency = input.nextDouble();
                
                System.out.println("Please input phase shift(phi in degrees) of the wave.");
                double phaseshiftdegrees = input.nextDouble();
                
                System.out.println("Please input a time value(t).");
                double timevalue = input.nextDouble();
                
                //diri kay i convert nato ang phase shift(which is in degrees) into radians kay mao na ang ginagamit for math.lang
                double phaseshiftRadians = toRadians(phaseshiftdegrees);
                double angularfrequency = 2 * PI * frequency; //we are solving for angular frequncy diri because it is needed to solve for the instantenous value of the wave at the given time
                //ang formula for angular frequency is 2 times pi times the frequency in hertz
                
                //ang formula sa instanenous value kay ( Amplitude * sin((angular frequency * time) + phase shift(in radians)) )
                double instantenousvalue = amplitude * sin((angularfrequency*timevalue) + phaseshiftRadians );
                
                //we are assigning a tolerance
                double tolerancewave = 1e-9; 
                
                //final print para sa instantenous value of the wave at the given time
                System.out.printf("Instantenous Value at time %.2f: %.4f\n", timevalue, instantenousvalue);
                
                //the following lines of code is used para ma determine nato ang location sa wave at the given time
                if ( abs( instantenousvalue - amplitude ) < tolerancewave ) { //this state na if the absolute value of (instantenous value - amplitude) is less than tolerance wave, then naa sya sa peak. This value is also equal to the amplitude so if duol jud sila then the result is 0.
                    System.out.println("The wave is at located at the PEAK.");
                } else if ( abs( instantenousvalue + amplitude ) < tolerancewave ) { //located at the lowest point of a wave, which equals to negative amplitude
                    System.out.println("The wave is at located at the TROUGH.");
                } else if ( abs( instantenousvalue ) < tolerancewave ) { //this checks if ang value ba sa instantenous value is 0.
                    System.out.println("The wave is at located at the ZERO-CROSSING.");
                } else { //Naa ang value between the peak, through, or zero-crossing.
                    System.out.println("The wave is at located at an intermediate value.");
                }
                
                //
                double argument = angularfrequency * timevalue + phaseshiftRadians;
                double nextpeakargument = PI / 2.0;
                
                //diri kay pangitaon nato ang current cycle number para sa peak
                double currentpeakcycle = floor( (argument - (PI / 2.0) ) / (2*PI) );
                
                //diri pud kay pangitaon ang next peak time sa cycle
                double nextpeaktime = (nextpeakargument + ( 2 * PI * (currentpeakcycle + 1 ) ) - phaseshiftRadians );
                
                System.out.printf("The next time the wave will reach a peak is t = %.4f\n", nextpeaktime);
                
            } catch (InputMismatchException e) {
                System.out.println("Please use numbers for the values.");
                input.nextLine();
            }
            
            
                        //Critical Thinking Questions
                    
                    //1. How did you determine if the wave is at a peak or trough?
                        //Nag depend sya sa iyang instantenous value relative to its amplitude. Naa sya sa peak if ang instant value is equal sa positive amplitude. Naa pud sya sa trough kung ang iyang value is equal sa negative amplitude.
                    //2. What mathematical approach did you use to find the next peak?
                        //gigamitan nakog (nextpeak + ( (2*PI*(currentpeak + 1) ) - phaseshiftRadians), which is the formula used here para makit an ang next peak time sa iyang given cycle.
                    //3. How would you modify this program to handle non-sinusoidal waves?
                        //Sa akong code, nag gamit kog sin and cos pero for this program to handle non-sinusoidal waves, lahi na mathematical function ang atong gamiton. Magamit gihapon nato ang concept sa pag find sa atong peak or trough but the method for finding the next one will be based on the specific function na nag define sa shape sa wave.
            
            
        input.close();
      }   
}