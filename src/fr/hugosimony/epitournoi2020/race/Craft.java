package fr.hugosimony.epitournoi2020.race;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import fr.hugosimony.epitournoi2020.Main;

public class Craft {
	
	public static final Location craftLocation = new Location(Bukkit.getWorld("world"), 3.5, 5, 15.5);

	public static void resetCraft(RacePlayer rplayer) {
		rplayer.clear();
		if(Main.main.craft == 1) {
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.LOG, 3));
			inv.addItem(new ItemStack(Material.WOOD, 3));
			inv.addItem(new ItemStack(Material.COBBLESTONE, 4));
			inv.addItem(new ItemStack(Material.STEP));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 4));
			inv.addItem(new ItemStack(Material.SLIME_BALL, 10));
			inv.addItem(new ItemStack(Material.IRON_INGOT, 24));
			inv.addItem(new ItemStack(Material.IRON_BLOCK));
			inv.addItem(new ItemStack(Material.DIAMOND_BLOCK));
			inv.addItem(new ItemStack(Material.OBSIDIAN, 4));
			inv.addItem(new ItemStack(Material.SUGAR_CANE, 4));
			inv.addItem(new ItemStack(Material.REDSTONE));
			inv.addItem(new ItemStack(Material.SPIDER_EYE));
			inv.addItem(new ItemStack(Material.BROWN_MUSHROOM));
		}
		else if(Main.main.craft == 2) {
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.GOLD_INGOT, 4));
			inv.addItem(new ItemStack(Material.GLOWSTONE_DUST, 4));
			inv.addItem(new ItemStack(Material.REDSTONE_BLOCK));
			inv.addItem(new ItemStack(Material.STONE, 6));
			inv.addItem(new ItemStack(Material.QUARTZ));
			inv.addItem(new ItemStack(Material.INK_SACK, 3, (short) 15));
			inv.addItem(new ItemStack(Material.STRING, 7));
			inv.addItem(new ItemStack(Material.WOOD, 2));
			inv.addItem(new ItemStack(Material.LOG, 2));
			inv.addItem(new ItemStack(Material.BONE, 2));
			//inv.addItem(new ItemStack(Material.INK_SACK));
			inv.addItem(new ItemStack(Material.COBBLESTONE, 7));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 20));
			inv.addItem(new ItemStack(Material.IRON_INGOT));
			inv.addItem(new ItemStack(Material.REDSTONE, 3));
		}
		else if(Main.main.craft == 3) {
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.SUGAR_CANE, 3));
			inv.addItem(new ItemStack(Material.LOG, 5));
			inv.addItem(new ItemStack(Material.SAND, 8));
			inv.addItem(new ItemStack(Material.WOOD, 2));
			inv.addItem(new ItemStack(Material.STRING, 26));
			inv.addItem(new ItemStack(Material.IRON_BLOCK));
			inv.addItem(new ItemStack(Material.IRON_INGOT));
			inv.addItem(new ItemStack(Material.FEATHER));
			inv.addItem(new ItemStack(Material.SULPHUR, 5));
			inv.addItem(new ItemStack(Material.DIAMOND, 6));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 4));
			inv.addItem(new ItemStack(Material.INK_SACK));
		}
		else if(Main.main.craft == 4) {
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.DIAMOND, 2));
			inv.addItem(new ItemStack(Material.PRISMARINE_CRYSTALS, 5));
			inv.addItem(new ItemStack(Material.SUGAR_CANE, 3));
			inv.addItem(new ItemStack(Material.LOG, 2));
			inv.addItem(new ItemStack(Material.SHULKER_SHELL, 2));
			inv.addItem(new ItemStack(Material.IRON_BLOCK));
			inv.addItem(new ItemStack(Material.ENDER_PEARL));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 4));
			inv.addItem(new ItemStack(Material.BLAZE_ROD));
			inv.addItem(new ItemStack(Material.WHEAT, 9));
			inv.addItem(new ItemStack(Material.PRISMARINE_SHARD, 8));
			inv.addItem(new ItemStack(Material.OBSIDIAN, 12));
			inv.addItem(new ItemStack(Material.SLIME_BALL));
		}
		else if(Main.main.craft == 5) {
			rplayer.player.sendMessage("§9 Indice : Un outil en bois est toujours utile :p");
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.COBBLESTONE, 15));
			inv.addItem(new ItemStack(Material.STONE, 3));
			inv.addItem(new ItemStack(Material.LOG, 6));
			inv.addItem(new ItemStack(Material.SUGAR_CANE, 9));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 12));
			inv.addItem(new ItemStack(Material.QUARTZ, 5));
			inv.addItem(new ItemStack(Material.STRING, 11));
			inv.addItem(new ItemStack(Material.WOOL));
			inv.addItem(new ItemStack(Material.BLAZE_ROD, 2));
			inv.addItem(new ItemStack(Material.SLIME_BALL, 4));
			inv.addItem(new ItemStack(Material.REDSTONE, 5));
		}
		else if(Main.main.craft == 6) {
			rplayer.player.sendMessage("§9 Indice : Du stockage à transporter, c'est bien !");
			PlayerInventory inv = rplayer.player.getInventory();
			for(int i = 0; i < rplayer.craftsDone.length; i++)
				rplayer.craftsDone[i] = false;
			inv.addItem(new ItemStack(Material.CARROT_ITEM, 2));
			inv.addItem(new ItemStack(Material.GOLD_NUGGET, 44));
			inv.addItem(new ItemStack(Material.STRING, 26));
			inv.addItem(new ItemStack(Material.LOG, 4));
			inv.addItem(new ItemStack(Material.IRON_INGOT, 5));
			inv.addItem(new ItemStack(Material.COBBLESTONE, 3));
			inv.addItem(new ItemStack(Material.BLAZE_ROD, 3));
			inv.addItem(new ItemStack(Material.REDSTONE));
			inv.addItem(new ItemStack(Material.SLIME_BALL, 4));
			inv.addItem(new ItemStack(Material.RABBIT_HIDE, 4));
		}
	}
	
	public static boolean checkCraft(RacePlayer rplayer, ItemStack item) {
		if(Main.main.craft == 1) {
			if(item.getType() == Material.PISTON_STICKY_BASE) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.DIAMOND_LEGGINGS) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.SLIME_BLOCK) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.IRON_SPADE) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.CHEST) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.FERMENTED_SPIDER_EYE) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.ENCHANTMENT_TABLE) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.ANVIL) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.ARMOR_STAND) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		else if(Main.main.craft == 2) {
			if(item.getType() == Material.WOOL) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.REDSTONE_LAMP_OFF) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.LEATHER_CHESTPLATE) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.DIODE) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.SHIELD) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.BONE_BLOCK) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.DISPENSER) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.REDSTONE_COMPARATOR) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.WATCH) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		else if(Main.main.craft == 3) {
			if(item.getType() == Material.TNT) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.FENCE_GATE) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.BANNER) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.FISHING_ROD) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.JUKEBOX) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.HOPPER_MINECART) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.SANDSTONE) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.BOOK_AND_QUILL) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.DIAMOND_HELMET) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		else if(Main.main.craft == 4) {
			if(item.getType() == Material.HAY_BLOCK) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.ENCHANTMENT_TABLE) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.MAGMA_CREAM) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.SEA_LANTERN) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.PURPLE_SHULKER_BOX) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.CAULDRON_ITEM) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.SHEARS) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.ENDER_CHEST) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.PRISMARINE) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		else if(Main.main.craft == 5) {
			if(item.getType() == Material.BOOKSHELF) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.MAGMA) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.FURNACE) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.WOOD_PICKAXE) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.BED) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.DISPENSER) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.REDSTONE_COMPARATOR) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.NOTE_BLOCK) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.QUARTZ_BLOCK) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		else if(Main.main.craft == 6) {
			if(item.getType() == Material.WATCH) {
				rplayer.craftsDone[0] = true;
				return true;
			}
			if(item.getType() == Material.CARROT_STICK) {
				rplayer.craftsDone[1] = true;
				return true;
			}
			if(item.getType() == Material.BANNER) {
				rplayer.craftsDone[2] = true;
				return true;
			}
			if(item.getType() == Material.ITEM_FRAME) {
				rplayer.craftsDone[3] = true;
				return true;
			}
			if(item.getType() == Material.STORAGE_MINECART) {
				rplayer.craftsDone[4] = true;
				return true;
			}
			if(item.getType() == Material.BREWING_STAND_ITEM) {
				rplayer.craftsDone[5] = true;
				return true;
			}
			if(item.getType() == Material.WOOD_PLATE) {
				rplayer.craftsDone[6] = true;
				return true;
			}
			if(item.getType() == Material.MAGMA) {
				rplayer.craftsDone[7] = true;
				return true;
			}
			if(item.getType() == Material.GOLDEN_CARROT) {
				rplayer.craftsDone[8] = true;
				return true;
			}
		}
		return false;
	}
	
}
