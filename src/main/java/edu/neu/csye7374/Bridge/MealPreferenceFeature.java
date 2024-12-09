package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;
import java.util.Arrays;
import java.util.List;

public class MealPreferenceFeature extends AbstractTicketFeature {
    private String mealPreference;
    private static final List<String> VALID_MEAL_PREFERENCES = Arrays.asList(
            "REGULAR", "VEGETARIAN", "VEGAN", "HALAL", "KOSHER", "GLUTEN_FREE"
    );

    public MealPreferenceFeature(String mealPreference) {
        super();
        this.mealPreference = mealPreference.toUpperCase();
    }

    @Override
    protected void performFeatureApplication(Booking ticket) {
        String oldPreference = ticket.getMealPreference();
        ticket.setMealPreference(mealPreference);
        System.out.println(String.format(
                "Meal preference changed from %s to %s for passenger %s %s",
                oldPreference,
                mealPreference,
                ticket.getCustomer().getFirstName(),
                ticket.getCustomer().getLastName()
        ));
    }

    @Override
    public boolean validateFeature(Booking ticket) {
        return VALID_MEAL_PREFERENCES.contains(mealPreference) &&
                !mealPreference.equals(ticket.getMealPreference());
    }

    @Override
    public String getFeatureDescription() {
        return "Meal Preference Change to " + mealPreference;
    }
}