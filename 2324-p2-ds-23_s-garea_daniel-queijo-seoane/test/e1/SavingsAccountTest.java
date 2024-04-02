package e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private static SavingsAccount savingsAccount;

    @BeforeAll
    public static void setUp() {
        savingsAccount = new SavingsAccount("ES123456789");
    }

    @Test
    public void testConstructor() {
        assertEquals("ES123456789", savingsAccount.getIBAN());
        assertEquals(0.0, savingsAccount.getBalance(), 0.001);
        assertEquals(0.04, savingsAccount.getCommission(), 0.001);
        assertEquals(1000.0, savingsAccount.getMinimumDeposit(), 0.001);
        assertEquals(3.0, savingsAccount.getMinimumCommission(), 0.001);
    }

    @Test
    public void testSetCommission() {
        savingsAccount.setCommission(0.03);
        assertEquals(0.03, savingsAccount.getCommission(), 0.001);
    }

    @Test
    public void testSetMinimumDeposit() {
        savingsAccount.setMinimumDeposit(500.0);
        assertEquals(500.0, savingsAccount.getMinimumDeposit(), 0.001);
    }

    @Test
    public void testSetMinimumCommission() {
        savingsAccount.setMinimumCommission(2.0);
        assertEquals(2.0, savingsAccount.getMinimumCommission(), 0.001);
    }

    @Test
    public void testDepositWithMinimumDeposit() {
        savingsAccount.deposit(1000.0);
        assertEquals(1000.0, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawWithCommission() {
        savingsAccount.deposit(1000.0);
        assertTrue(savingsAccount.withdraw(100.0));
        // Commission is 0.04, minimumCommission is 3, so commission charged should be at least 3
        assertEquals(896.96, savingsAccount.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawBelowMinimumCommission() {
        savingsAccount.deposit(1000.0);
        assertTrue(savingsAccount.withdraw(50.0));
        // Commission is 0.04, minimumCommission is 3, so commission charged should be 3
        assertEquals(947.0, savingsAccount.getBalance(), 0.01);
    }
}
