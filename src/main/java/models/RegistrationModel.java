package models;

public class RegistrationModel extends BaseModel {

    public static RegistrationModel InvalidPasswordRegistrationModel = new RegistrationModel(
            "Irina",
            "Dedja",
            "idedja@kotemkot.com",
            "password",
            "password"
    );
    public static RegistrationModel ValidCredentials = new RegistrationModel(
            "Irina",
            "Dedja",
            "irii@mailinator.com",
            "Test@123",
            "password"
    );

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String confirmPassword;


    public RegistrationModel() {
        this.generate();
    }

    public RegistrationModel(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public void generate() {
        this.firstName = this.faker.name().firstName();
        this.lastName = this.faker.name().lastName();
        this.emailAddress = this.faker.internet().emailAddress();
        this.password = "Test@123";
        this.confirmPassword = this.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
