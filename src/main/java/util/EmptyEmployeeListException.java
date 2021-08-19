package util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmptyEmployeeListException extends Exception {
    public EmptyEmployeeListException(String message) {
        super(message);
    }
}
