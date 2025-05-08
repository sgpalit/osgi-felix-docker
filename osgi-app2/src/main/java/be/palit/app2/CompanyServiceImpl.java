package be.palit.app2;

public class CompanyServiceImpl implements CompanyService {

    @Override
    public String greet(String name) {
        return "Hello, " + name;
    }
}
