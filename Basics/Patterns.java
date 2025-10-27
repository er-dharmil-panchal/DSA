package Basics;

/**
 * Patterns
 */
public class Patterns {

    public static void main(String[] args) {

        // Pattern 1 - Square Pattern (Too Basic)
        System.out.println("Pattern1");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 2 - Right Angled Triangle (Too Basic)
        System.out.println("\nPattern2");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 3 - Numerical Right Angled Triangle (Too Basic)
        System.out.println("\nPattern3");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Patterns 4 - Row Number Triangle (To Basic)
        System.out.println("\nPattern4");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Pattern 5 - Inverted Right Angled Triangle (Too Basic)
        System.out.println("\nPattern5");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 6 - Numerical Inverted Right Angled Triangle (Too Basic)
        System.out.println("\nPattern6");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= (5 + 1 - i); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Pattern 7 - Pyramid Pattern (Basic)
        System.out.println("\nPattern7");
        for (int i = 1; i <= 5; i++) {
            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // Pattern 8 - Reverse Pyramid Pattern (Basic)
        System.out.println("\nPattern8");
        for (int i = 1; i <= 5; i++) {
            // Spaces
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= ((2 * 5) - (2 * i) + 1); j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // Pattern 9 - Diamond Pattern (7+8)
        System.out.println("\nPattern9");
        // Upper Half
        for (int i = 1; i <= 5; i++) {
            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower Half
        for (int i = 1; i <= 5; i++) {
            // Spaces
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= ((2 * 5) - (2 * i) + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pattern 10 - left Aligned Diamond Pattern
        System.out.println("\nPattern10");
        for (int i = 1; i <= (2 * 5) - 1; i++) {
            int s = i;
            if (i > 5) {
                s = (2 * 5) - i;
            }
            for (int j = 1; j <= s; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pattern 11 - 0-1 Triangle Pattern
        System.out.println("\nPattern11");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        // Pattern 12 - Mirror Right Angled Triangle
        System.out.println("\nPattern12");
        for (int i = 1; i <= 5; i++) {
            // Number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Spaces
            for (int k = 1; k <= (2 * 5) - (2 * i); k++) {
                System.out.print(" ");
            }
            // Number
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

        // Pattern 13 - continuous Number triangle
        System.out.println("\nPattern13");
        int count = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }

        // Pattern 14 - Alphabet Pattern
        System.out.println("\nPattern14");
        for (int i = 1; i <= 5; i++) {
            for (char j = 'A'; j < 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Pattern 15 - reverse Alphabet Pattern
        System.out.println("\nPattern15");
        for (int i = 1; i <= 5; i++) {
            char ch = 'A';
            for (int j = i; j <= 5; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }

        // Pattern 16 - Row-wise Alphabet Pattern
        System.out.println("\nPattern16");
        char ch = 'A';
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }

        // Pattern 17 - Alphabet Pyramid Pattern
        System.out.println("\nPattern17");
        for (int i = 1; i <= 5; i++) {
            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            // Alphabets
            char ch1 = 'A';
            int breakpoint = ((2 * i) - 1) / 2;
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print(ch1);
                if (j <= breakpoint) {
                    ch1++;
                } else {
                    ch1--;
                }
            }
            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        
        // Pattern 18 - Reverse Alphabet Triangle
        System.out.println("\nPattern18");
        for (int i = 1; i <= 5; i++) {
            ch = 'E';
            for (int j = 'E' - i + 1; j <= 'E'; j++) {
                System.out.print((char) j + " ");
            }
            System.out.println();
        }

        // Pattern 19 - Complement of Diamond Pattern
        System.out.println("\nPattern19");
        for (int i = 1; i <= 5; i++) {
            // stars
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            // spaces
            for (int j = (2 * 5); j > (2 * 5 - (2 * i) + 2); j--) {
                System.out.print(" ");
            }
            // stars
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 5; i >= 1; i--) {
            // stars
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            // spaces
            for (int j = (2 * 5); j > (2 * 5 - (2 * i) + 2); j--) {
                System.out.print(" ");
            }
            // stars
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pattern 20 - Butterfly Pattern
        System.out.println("\nPattern20");
        for (int i = 1; i <= 2*5; i++){
            int breakPoint = i;
            if (i>5) {
                breakPoint = 2*5 - i;
            }
            // stars
            for (int j = 1; j <= breakPoint; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= (2*5 - 2*breakPoint); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= breakPoint; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pattern 21 - Hollow Rectangle
        System.out.println("\nPattern21");
        for ( int i = 1; i<= 5; i++){
            for (int j = 1; j <= 5; j++){
                if(i==1 || i==5 || j==1 || j==5){
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Pattern 22 - Concentric Square Pattern (or Number Frame Pattern)
        System.out.println("\nPattern22");
        int n = 4;
        for (int i = 1; i <= (2*n)-1; i++) {
            for (int j =1; j<= (2*n)-1; j++){
                int top = i-1;
                int down = (2*n-1) - i;
                int left = j-1;
                int right = (2*n -1) - j;
                int min = Math.min(Math.min(top, down), Math.min(left, right));
                System.out.print(n-min);
            }
            System.out.println();
        }
    }
}