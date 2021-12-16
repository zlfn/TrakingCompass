package org.zlfn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PvPlugin extends JavaPlugin
{

    public static ItemStack compass1;
    public static ItemStack compass2;
    public static ItemStack compass3;
    public static ItemStack compass4;
    public static ItemStack compass5;
    public static ItemStack compass6;
    public static ItemStack compass7;
    public static ItemStack compass8;
    public static ItemStack compass9;
    public static Enchantment TRAKING = new EnchantmentWrapper("tracker","추적",10);

    public static void registerEnchantment(Enchantment enchantment)
    {
        boolean registered = true;
        try
        {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        }
        catch (Exception e)
        {
            registered = false;
            e.printStackTrace();
        }
    }

    public static void init() {
        registerEnchantment(TRAKING);
        createCompass();}

    private static void createCompass()
    {
        ItemStack compass1item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta1 = compass1item.getItemMeta();
        meta1.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.1");
        List<String> lore1 = new ArrayList<>();
        lore1.add("랜덤한 사람을 추적하는 나침반입니다");
        lore1.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore1.add("네더라이트 주괴 1개로 업그레이드하면 오차가 감소합니다");
        lore1.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta1.setLore(lore1);
        meta1.addEnchant(TRAKING,1,true);
        compass1item.setItemMeta(meta1);
        compass1 = compass1item;

        ShapedRecipe re1 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass1"),compass1);
        re1.shape(" I ",
                 "INI",
                 " I ");
        re1.setIngredient('I',Material.IRON_INGOT);
        re1.setIngredient('N',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re1);



        ItemStack compass2item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta2 = compass2item.getItemMeta();
        meta2.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.2");
        List<String> lore2 = new ArrayList<>();
        lore2.add("랜덤한 사람을 추적하는 나침반입니다");
        lore2.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore2.add("네더라이트 주괴 2개로 업그레이드하면 오차가 감소합니다");
        lore2.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta2.setLore(lore2);
        meta2.addEnchant(TRAKING,2,true);
        compass2item.setItemMeta(meta2);
        compass2 = compass2item;

        ShapedRecipe re2 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass2"),compass2);
        re2.shape("BA ",
                "   ",
                "   ");
        re2.setIngredient('A',new RecipeChoice.ExactChoice(compass1));
        re2.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re2);


        ItemStack compass3item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta3 = compass3item.getItemMeta();
        meta3.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.3");
        List<String> lore3 = new ArrayList<>();
        lore3.add("랜덤한 사람을 추적하는 나침반입니다");
        lore3.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore3.add("네더라이트 주괴 3개로 업그레이드하면 오차가 감소합니다");
        lore3.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta3.setLore(lore3);
        meta3.addEnchant(TRAKING,3,true);
        compass3item.setItemMeta(meta3);
        compass3 = compass3item;

        ShapedRecipe re3 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass3"),compass3);
        re3.shape("BBA",
                "   ",
                "   ");
        re3.setIngredient('A',new RecipeChoice.ExactChoice(compass2));
        re3.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re3);



        ItemStack compass4item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta4 = compass4item.getItemMeta();
        meta4.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.4");
        List<String> lore4 = new ArrayList<>();
        lore4.add("랜덤한 사람을 추적하는 나침반입니다");
        lore4.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore4.add("네더라이트 주괴 4개로 업그레이드하면 오차가 감소합니다");
        lore4.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta4.setLore(lore4);
        meta4.addEnchant(TRAKING,4,true);
        compass4item.setItemMeta(meta4);
        compass4 = compass4item;

        ShapedRecipe re4 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass4"),compass4);
        re4.shape("BBB",
                "A  ",
                "   ");
        re4.setIngredient('A',new RecipeChoice.ExactChoice(compass3));
        re4.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re4);



        ItemStack compass5item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta5 = compass5item.getItemMeta();
        meta5.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.5");
        List<String> lore5 = new ArrayList<>();
        lore5.add("랜덤한 사람을 추적하는 나침반입니다");
        lore5.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore5.add("네더라이트 주괴 5개로 업그레이드하면 오차가 감소합니다");
        lore5.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta5.setLore(lore5);
        meta5.addEnchant(TRAKING,5,true);
        compass5item.setItemMeta(meta5);
        compass5 = compass5item;

        ShapedRecipe re5 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass5"),compass5);
        re5.shape("BBB",
                "BA ",
                "   ");
        re5.setIngredient('A',new RecipeChoice.ExactChoice(compass4));
        re5.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re5);


        ItemStack compass6item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta6 = compass6item.getItemMeta();
        meta6.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.6");
        List<String> lore6 = new ArrayList<>();
        lore6.add("랜덤한 사람을 추적하는 나침반입니다");
        lore6.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore6.add("네더라이트 주괴 6개로 업그레이드하면 오차가 감소합니다");
        lore6.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta6.setLore(lore6);
        meta6.addEnchant(TRAKING,6,true);
        compass6item.setItemMeta(meta6);
        compass6 = compass6item;

        ShapedRecipe re6 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass6"),compass6);
        re6.shape("BBB",
                "BBA",
                "   ");
        re6.setIngredient('A',new RecipeChoice.ExactChoice(compass5));
        re6.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re6);


        ItemStack compass7item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta7 = compass7item.getItemMeta();
        meta7.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.7");
        List<String> lore7 = new ArrayList<>();
        lore7.add("랜덤한 사람을 추적하는 나침반입니다");
        lore7.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore7.add("네더라이트 주괴 7개로 업그레이드하면 오차가 감소합니다");
        lore7.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta7.setLore(lore7);
        meta7.addEnchant(TRAKING,7,true);
        compass7item.setItemMeta(meta7);
        compass7 = compass7item;

        ShapedRecipe re7 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass7"),compass7);
        re7.shape("BBB",
                "BBB",
                "A  ");
        re7.setIngredient('A',new RecipeChoice.ExactChoice(compass6));
        re7.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re7);


        ItemStack compass8item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta8 = compass8item.getItemMeta();
        meta8.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.8");
        List<String> lore8 = new ArrayList<>();
        lore8.add("랜덤한 사람을 추적하는 나침반입니다");
        lore8.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");
        lore8.add("네더라이트 주괴 8개로 업그레이드하면 오차가 감소합니다");
        lore8.add("조합 전 Shift+우클릭해서 나침반을 초기화해주세요.");

        meta8.setLore(lore8);
        meta8.addEnchant(TRAKING,8,true);
        compass8item.setItemMeta(meta8);
        compass8 = compass8item;

        ShapedRecipe re8 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass8"),compass8);
        re8.shape("BBB",
                "BBB",
                "BA ");
        re8.setIngredient('A',new RecipeChoice.ExactChoice(compass7));
        re8.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re8);


        ItemStack compass9item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta9 = compass9item.getItemMeta();
        meta9.setDisplayName(ChatColor.GOLD + "추적 나침반 Lv.9");
        List<String> lore9 = new ArrayList<>();
        lore9.add("랜덤한 사람의 완벽한 위치를 추적하는 나침반입니다");
        lore9.add("우클릭 할때마다 랜덤으로 사람을 추적합니다");

        meta9.setLore(lore9);
        meta9.addEnchant(TRAKING,9,true);
        compass9item.setItemMeta(meta9);
        compass9 = compass9item;

        ShapedRecipe re9 = new ShapedRecipe(NamespacedKey.minecraft("trackingcompass9"),compass9);
        re9.shape("BBB",
                "BBB",
                "BBA");
        re9.setIngredient('A',new RecipeChoice.ExactChoice(compass8));
        re9.setIngredient('B',Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(re9);
    }



    @Override
    public void onEnable()
    {
        Listener myEvtHnd = new EvListener();
        Bukkit.getPluginManager().registerEvents(myEvtHnd, this);
        init();
        Bukkit.getConsoleSender().sendMessage("TrakingCompass Enabled!");
    }


    @Override
    public void onDisable()
    {

    }

}