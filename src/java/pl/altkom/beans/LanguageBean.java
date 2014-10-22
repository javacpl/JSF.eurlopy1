package pl.altkom.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class LanguageBean implements Serializable {

    private String language;

    public String switchLocale() {
        switch (language) {
            case "pl":
                language = Locale.EN.name().toLowerCase();
                break;
            case "en":
                language = Locale.PL.name().toLowerCase();
                break;
        }
        return "logout";
    }

    public boolean isPolish() {
        return language.equalsIgnoreCase(Locale.PL.name());
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LanguageBean() {
        language = Locale.PL.name().toLowerCase();
    }
}

enum Locale {

    PL, EN;
}
