package burger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionOfExtras {
    private List<Extras> extras;

    public SelectionOfExtras(Extras extra1, Extras extra2, Extras extra3, Extras extra4) {
        extras = new ArrayList<>();
        Collections.addAll(extras, extra1, extra2, extra3, extra4);
    }

    public List<Extras> getExtras() {
        return extras;
    }

    @Override
    public String toString() {
        StringBuilder stringOfExtras = new StringBuilder();
        int counter = 0;
        for (Extras extra : extras) {
            if (counter < extras.size() - 1) {
                stringOfExtras.append(extra.getName()).append(" - ").append(extra.getPrice()).append(" €; ");
            } else {
                stringOfExtras.append(extra.getName()).append(" - ").append(extra.getPrice()).append(" €; ");
            }
            counter++;
        }
        return stringOfExtras.toString();
    }
}
