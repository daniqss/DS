package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private static BankAccount bankAccount;

    @BeforeAll
    public static void setUp() {
        bankAccount = new CurrentAccount("ES123456789");
    }

    @Test
    public void testConstructor() {
        assertEquals("ES123456789", bankAccount.getIBAN());
        assertEquals(0.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        assertEquals(100.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawWithFunds() {
        bankAccount.deposit(200.0);
        assertTrue(bankAccount.withdraw(50.0));
        assertEquals(150.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawWithoutFunds() {
        assertFalse(bankAccount.withdraw(50.0));
        assertEquals(0.0, bankAccount.getBalance(), 0.001);
    }
}

