import java.util.Map;
import java.util.Scanner;

class IngredientService {
    private final Map<String, String> swaps = Map.ofEntries(
            Map.entry("sugar", "honey or stevia"),
            Map.entry("artificial sweeteners", "raw honey or date syrup"),
            Map.entry("maple syrup", "apple sauce or cinnamon"),
            Map.entry("white rice", "brown rice or quinoa"),
            Map.entry("white bread", "whole grain or sourdough bread"),
            Map.entry("regular pasta", "whole wheat or lentil pasta"),
            Map.entry("flour tortillas", "corn tortillas or lettuce wraps"),
            Map.entry("potato chips", "air-popped popcorn or roasted chickpeas"),
            Map.entry("butter", "olive oil or avocado"),
            Map.entry("cream", "Greek yogurt"),
            Map.entry("whole milk", "almond milk or oat milk"),
            Map.entry("heavy cream", "blended cashews or coconut cream"),
            Map.entry("sour cream", "Greek yogurt or blended tofu"),
            Map.entry("cheese", "nutritional yeast or cottage cheese"),
            Map.entry("vegetable oil", "avocado oil or coconut oil"),
            Map.entry("margarine", "grass-fed butter or nut butter"),
            Map.entry("mayonnaise", "mashed avocado or hummus"),
            Map.entry("red meat", "lean chicken, turkey, or tofu"),
            Map.entry("bacon", "smoked salmon or tempeh"),
            Map.entry("fried chicken", "grilled chicken or baked fish"),
            Map.entry("processed deli meats", "fresh turkey or chicken slices"),
            Map.entry("soda", "sparkling water with lemon"),
            Map.entry("energy drinks", "green tea or matcha"),
            Map.entry("creamy coffee drinks", "black coffee with cinnamon"),
            Map.entry("flavored yogurt drinks", "kefir or homemade smoothies"),
            Map.entry("ice cream", "frozen yogurt or banana ice cream"),
            Map.entry("candy", "dark chocolate or dried fruit"),
            Map.entry("cookies", "oatmeal cookies or protein bars"),
            Map.entry("cake", "fruit salad or chia pudding"),
            Map.entry("brownies", "black bean brownies or protein brownies"),
            Map.entry("pancakes", "oatmeal pancakes or protein pancakes"),
            Map.entry("waffles", "sweet potato waffles or protein waffles"),
            Map.entry("pizza", "cauliflower crust pizza or veggie pizza"),
            Map.entry("regular chips", "baked veggie chips or kale chips"),
            Map.entry("granola bars", "homemade energy balls or nuts"),
            Map.entry("fruit juice", "whole fruit or infused water"),
            Map.entry("sweetened cereal", "oatmeal or unsweetened cereal"),
            Map.entry("instant noodles", "zucchini noodles or whole grain pasta"),
            Map.entry("canned soup", "homemade soup or vegetable broth"),
            Map.entry("processed snacks", "nuts or seeds"),
            Map.entry("fast food", "homemade burgers or salads")



    );

    public void suggestAlternative(Scanner scanner) {
        System.out.print("Enter a food item to find a healthier alternative: ");
        String input = scanner.nextLine().trim().toLowerCase();

        String suggestion = swaps.getOrDefault(input, "No healthy alternative found for that item.");
        System.out.println("Alternative: " + suggestion);
    }
}
