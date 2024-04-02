package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private BankAccount bankAccount;
    private Client client;

    @BeforeEach
    public void setup() {
        bankAccount = new SavingsAccount("SavingsIBAN");
        client = new StandardClient("DNI123", bankAccount);
    }

    @Test
    public void testClientConstructor() {
        assertEquals("DNI123", client.getDNI());
        assertEquals(bankAccount, client.getBankAccount());
    }

    @Test
    public void testSetDNI() {
        client.setDNI("NewDNI");
        assertEquals("NewDNI", client.getDNI());
    }

    @Test
    public void testSetBankAccount() {
        BankAccount newAccount = new CurrentAccount("CurrentIBAN");
        client.setBankAccount(newAccount);
        assertEquals(newAccount, client.getBankAccount());
    }
}

