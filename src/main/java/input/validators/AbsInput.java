package input.validators;

import java.util.Scanner;

public abstract class AbsInput {

    protected Scanner scanner;

    public AbsInput() {
        this.scanner = new Scanner(System.in);
    }
}
