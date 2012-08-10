import geb.Module
import org.openqa.selenium.Keys

class GoogleSearchModule extends Module {
    static content = {
        searchForm                      { $('form#gbqf')                        }
        field                           { searchForm.find('input', name: 'q')   }
        button(to: GoogleResultsPage)   { $('button#gbqfba')                    }
    }

    void forTerm(term) {
        field << term
        field << Keys.RETURN
    }
}
