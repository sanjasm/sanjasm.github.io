package alps.net.api.api.util;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

/**
 * This interface simplifies the use of {@link Triple} when no {@link IGraph} is currently given to create a real triple,
 * or as quick mock for a real triple.
 * An incomplete triple is only valid when bound to a class that acts as subject,
 * because the incomplete triple does not parse subject information (only object and predicate).
 * An IncompleteTriple might either contain information about the object, or about "objectWithExtra" ({@link #getObjectWithExtra()})
 * Not both at the same time.
 */
public interface IIncompleteTriple {

    /**
     * Returns a real triple to the incomplete triple,
     * therefor a subject must be provided
     *
     * @param model The {@link Model} that is used to create the triple
     * @param subjectNode the subject that will be subject of the new triple
     * @return The real triple
     */
    Triple getRealTriple(Model model, Resource subjectNode);

    /**
     * Get the predicate attribute of the incomplete triple
     *
     * @return predicate attribute as a {@link String}
     */
    String getPredicate();

    /**
     * Get the object attribute of the incomplete triple
     *
     * @return object attribute as a {@link String}
     */
    String getObject();

    /**
     * Get the object attribute + extra attribute (language tag or datatype) of the incomplete triple
     *
     * @return object attribute + extra attribute as a {@link IStringWithExtra}
     */
    IStringWithExtra getObjectWithExtra();
}
