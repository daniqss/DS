package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PreferentialClientTest {
    private BankAccount bankAccount;
    private Client client;

    @BeforeEach
    public void setUp() {
        bankAccount = new SavingsAccount("SavingsIBAN");
        client = new PreferentialClient("123456789A", bankAccount);
    }

    @Test
    public void testPreferentialClientConstructor() {
        assertEquals("123456789A", client.getDNI());
        assertEquals(bankAccount, client.getBankAccount());

        if (bankAccount instanceof SavingsAccount savingsAccount) {
            // Verifica que la comisión, el límite mínimo de ingreso y el límite mínimo para intereses se hayan modificado correctamente
            assertEquals(0.02, savingsAccount.getCommission());
            assertEquals(500.0, savingsAccount.getMinimumDeposit());
            assertEquals(1.0, savingsAccount.getMinimumCommission());
        } else {
            fail("Bank account is not an instance of SavingsAccount");
        }
    }

    @Test
    public void testWithdrawWithSufficientFunds() {
        // Depositamos $1000 en la cuenta
        bankAccount.deposit(1000.0);

        if (client instanceof PreferentialClient preferentialClient) { // Verificamos si es una instancia de PreferentialClient
            assertTrue(preferentialClient.withdraw(200.0));
            assertEquals(800.0, bankAccount.getBalance(), 0.01);
        } else {
            fail("Client is not an instance of PreferentialClient or VIPClient");
        }
    }

    @Test
    public void testWithdrawBelowMinimumCommission() {
        // Depositamos $1000 en la cuenta
        bankAccount.deposit(1000.0);
        if (client instanceof PreferentialClient preferentialClient) { // Verificamos si es una instancia de PreferentialClient
            assertTrue(preferentialClient.withdraw(50.0)); // Intentamos retirar $50, que debería resultar en una comisión de $1
            assertEquals(949.0, bankAccount.getBalance(), 0.01);
        } else {
            fail("Client is not an instance of PreferentialClient");
        }
    }
}
