import spock.lang.Unroll
import geb.spock.GebReportingSpec

@Unroll
class SeoSpec extends GebReportingSpec {

    def "it-agile should be first result for #term on google"() {
        when:
        to GoogleHomePage

        and:
        search.forTerm term

        then:
        at GoogleResultsPage

        when:
        waitFor { results }
        firstResultLink.click()

        then:
        waitFor { at ItAgileHomePage }

        where:
        term << [ 'it-agile', 'it agile', 'it agile munich' ]
    }
}
