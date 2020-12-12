package fr.hugosimony.epitournoi2020.race;

import fr.hugosimony.epitournoi2020.utils.Utils;

public class Elytra {

	public static void checkCheckpoints(RacePlayer rplayer, double x, double y, double z) {
		boolean[] checkpoints = rplayer.elytraCheckpoints;
		if(checkpoints[0] && !checkpoints[1] && Utils.isIn(-323, -320,  93,  97,  -309,  -305, x, y, z)){
			checkpoints[1] = true;
			rplayer.setElytraCheckpoint(1);
		}
		else if(checkpoints[1] && !checkpoints[2] && Utils.isIn(-344, -340, 109, 113, -298, -295, x, y, z)){
			checkpoints[2] = true;
			rplayer.setElytraCheckpoint(2);
		}
		else if(checkpoints[2] && !checkpoints[3] && Utils.isIn(-330, -327, 135, 139, -286, -282, x, y, z)){
			checkpoints[3] = true;
			rplayer.setElytraCheckpoint(3);
		}
		else if(checkpoints[3] && !checkpoints[4] && Utils.isIn(-310, -306, 138, 142, -317, -314, x, y, z)){
			checkpoints[4] = true;
			rplayer.setElytraCheckpoint(4);
		}
		else if(checkpoints[4] && !checkpoints[5] && Utils.isIn(-309, -305, 104, 107, -367, -363, x, y, z)){
			checkpoints[5] = true;
			rplayer.setElytraCheckpoint(5);
		}
		else if(checkpoints[5] && !checkpoints[6] && Utils.isIn(-335, -332, 81, 85, -379, -375, x, y, z)){
			checkpoints[6] = true;
			rplayer.setElytraCheckpoint(6);
		}
		else if(checkpoints[6] && !checkpoints[7] && Utils.isIn(-405, -402, 82, 86, -379, -375, x, y, z)){
			checkpoints[7] = true;
			rplayer.setElytraCheckpoint(7);
		}
		else if(checkpoints[7] && !checkpoints[8] && Utils.isIn(-417, -413, 85, 89, -346, -343, x, y, z)){
			checkpoints[8] = true;
			rplayer.setElytraCheckpoint(8);
		}
		else if(checkpoints[8] && !checkpoints[9] && Utils.isIn(-462, -459, 109, 113, -295, -291, x, y, z)){
			checkpoints[9] = true;
			rplayer.setElytraCheckpoint(9);
		}
		else if(checkpoints[9] && !checkpoints[10] && Utils.isIn(-489, -485, 155, 158, -290, -286, x, y, z)){
			checkpoints[10] = true;
			rplayer.setElytraCheckpoint(10);
		}
		else if(checkpoints[10] && !checkpoints[11] && Utils.isIn(-467, -464, 162, 166, -274, -270, x, y, z)){
			checkpoints[11] = true;
			rplayer.setElytraCheckpoint(11);
		}
		else if(checkpoints[11] && !checkpoints[12] && Utils.isIn(-436, -432, 161, 165, -324, -321, x, y, z)){
			checkpoints[12] = true;
			rplayer.setElytraCheckpoint(12);
		}
		else if(checkpoints[12] && !checkpoints[13] && Utils.isIn(-444, -440, 177, 181, -373, -370, x, y, z)){
			checkpoints[13] = true;
			rplayer.setElytraCheckpoint(13);
		}
		else if(checkpoints[13] && !checkpoints[14] && Utils.isIn(-430, -426, 155, 159, -424, -421, x, y, z)){
			checkpoints[14] = true;
			rplayer.setElytraCheckpoint(14);
		}
		else if(checkpoints[14] && !checkpoints[15] && Utils.isIn(-478, -475, 151, 155, -482, -478, x, y, z)){
			checkpoints[15] = true;
			rplayer.setElytraCheckpoint(15);
		}
		else if(checkpoints[15] && !checkpoints[16] && Utils.isIn(-544, -541, 162, 166, -488, -484, x, y, z)){
			checkpoints[16] = true;
			rplayer.setElytraCheckpoint(16);
		}
		else if(checkpoints[16] && !checkpoints[17] && Utils.isIn(-576, -572, 191, 194, -490, -486, x, y, z)){
			checkpoints[17] = true;
			rplayer.setElytraCheckpoint(17);
		}
		else if(checkpoints[17] && !checkpoints[18] && Utils.isIn(-548, -544, 222, 226, -415, -412, x, y, z)){
			checkpoints[18] = true;
			rplayer.setElytraCheckpoint(18);
		}
		else if(checkpoints[18] && !checkpoints[19] && Utils.isIn(-507, -503, 224, 228, -345, -342, x, y, z)){
			checkpoints[19] = true;
			rplayer.setElytraCheckpoint(19);
		}
		else if(checkpoints[19] && !checkpoints[20] && Utils.isIn(-526, -523, 224, 228, -283, -279, x, y, z)){
			checkpoints[20] = true;
			rplayer.setElytraCheckpoint(20);
		}
		else if(checkpoints[20] && !checkpoints[21] && Utils.isIn(-581, -577, 228, 231, -282, -278, x, y, z)){
			checkpoints[21] = true;
			rplayer.setElytraCheckpoint(21);
		}
		else if(checkpoints[21] && !checkpoints[22] && Utils.isIn(-615, -612, 226, 230, -282, -278, x, y, z)){
			checkpoints[22] = true;
			rplayer.setElytraCheckpoint(22);
		}
		else if(checkpoints[22] && !checkpoints[23] && Utils.isIn(-664, -660, 228, 232, -315, -312, x, y, z)){
			checkpoints[23] = true;
			rplayer.setElytraCheckpoint(23);
		}
		else if(checkpoints[23] && !checkpoints[24] && Utils.isIn(-646, -642, 238, 242, -377, -374, x, y, z)){
			checkpoints[24] = true;
			rplayer.setElytraCheckpoint(24);
		}
		else if(checkpoints[24] && !checkpoints[25] && Utils.isIn(-646, -642, 196, 199, -405, -401, x, y, z)){
			checkpoints[25] = true;
			rplayer.setElytraCheckpoint(25);
		}
		else if(checkpoints[25] && !checkpoints[26] && Utils.isIn(-646, -642, 148, 151, -405, -401, x, y, z)){
			checkpoints[26] = true;
			rplayer.setElytraCheckpoint(26);
		}
		else if(checkpoints[26] && !checkpoints[27] && Utils.isIn(-645, -641, 98, 102, -438, -435, x, y, z)){
			checkpoints[27] = true;
			rplayer.setElytraCheckpoint(27);
		}
		else if(checkpoints[27] && !checkpoints[28] && Utils.isIn(-687, -684, 117, 121, -480, -476, x, y, z)){
			checkpoints[28] = true;
			rplayer.setElytraCheckpoint(28);
		}
		else if(checkpoints[28] && !checkpoints[29] && Utils.isIn(-722, -718, 140, 144, -463, -460, x, y, z)){
			checkpoints[29] = true;
			rplayer.setElytraCheckpoint(29);
		}
		else if(checkpoints[29] && !checkpoints[30] && Utils.isIn(-710, -706, 143, 147, -415, -412, x, y, z)){
			checkpoints[30] = true;
			rplayer.setElytraCheckpoint(30);
		}
		else if(checkpoints[30] && !checkpoints[31] && Utils.isIn(-729, -726, 137, 141, -366, -362, x, y, z)){
			checkpoints[31] = true;
			rplayer.setElytraCheckpoint(31);
		}
		else if(checkpoints[31] && !checkpoints[32] && Utils.isIn(-767, -764, 162, 165, -362, -359, x, y, z)){
			checkpoints[32] = true;
			rplayer.setElytraCheckpoint(32);
		}
		else if(checkpoints[32] && !checkpoints[33] && Utils.isIn(-775, -772, 190, 193, -389, -386, x, y, z)){
			checkpoints[33] = true;
			rplayer.setElytraCheckpoint(33);
		}
		else if(checkpoints[33] && !checkpoints[34] && Utils.isIn(-764, -761, 181, 184, -413, -410, x, y, z)){
			checkpoints[34] = true;
			rplayer.setElytraCheckpoint(34);
		}
		else if(checkpoints[34] && !checkpoints[35] && Utils.isIn(-790, -787, 187, 190, -449, -446, x, y, z)){
			checkpoints[35] = true;
			rplayer.setElytraCheckpoint(35);
		}
		else if(checkpoints[35] && !checkpoints[36] && Utils.isIn(-842, -839, 189, 192, -449, -446, x, y, z)){
			checkpoints[36] = true;
			rplayer.setElytraCheckpoint(36);
		}
		else if(checkpoints[36] && !checkpoints[37] && Utils.isIn(-862, -859, 183, 186, -425, -422, x, y, z)){
			checkpoints[37] = true;
			rplayer.setElytraCheckpoint(37);
		}
		else if(checkpoints[37] && !checkpoints[38] && Utils.isIn(-862, -859, 183, 186, -412, -409, x, y, z)){
			checkpoints[38] = true;
			rplayer.setElytraCheckpoint(38);
		}
		else if(checkpoints[38] && !checkpoints[39] && Utils.isIn(-862, -859, 183, 186, -398, -395, x, y, z)){
			checkpoints[39] = true;
			rplayer.setElytraCheckpoint(39);
		}
		else if(checkpoints[39] && !checkpoints[40] && Utils.isIn(-862, -859, 183, 186, -386, -383, x, y, z)){
			checkpoints[40] = true;
			rplayer.setElytraCheckpoint(40);
		}
		else if(checkpoints[40] && !checkpoints[41] && Utils.isIn(-880, -877, 187, 190, -359, -356, x, y, z)){
			checkpoints[41] = true;
			rplayer.setElytraCheckpoint(41);
		}
		else if(checkpoints[41] && !checkpoints[42] && Utils.isIn(-918, -915, 202, 205, -378, -375, x, y, z)){
			checkpoints[42] = true;
			rplayer.setElytraCheckpoint(42);
		}
		else if(checkpoints[42] && !checkpoints[43] && Utils.isIn(-903, -900, 187, 190, -403, -400, x, y, z)){
			checkpoints[43] = true;
			rplayer.setElytraCheckpoint(43);
		}
		else if(checkpoints[43] && !checkpoints[44] && Utils.isIn(-915, -912, 200, 203, -414, -411, x, y, z)){
			checkpoints[44] = true;
			rplayer.setElytraCheckpoint(44);
		}
		else if(checkpoints[44] && !checkpoints[45] && Utils.isIn(-917, -914, 200, 203, -455, -452, x, y, z)){
			checkpoints[45] = true;
			rplayer.setElytraCheckpoint(45);
		}
		else if(checkpoints[45] && !checkpoints[46] && Utils.isIn(-920, -917, 203, 206, -462, -459, x, y, z)){
			checkpoints[46] = true;
			rplayer.setElytraCheckpoint(46);
		}
		else if(checkpoints[46] && !checkpoints[47] && Utils.isIn(-936, -933, 190, 193, -461, -458, x, y, z)){
			checkpoints[47] = true;
			rplayer.setElytraCheckpoint(47);
		}
		else if(checkpoints[47] && !checkpoints[48] && Utils.isIn(-964, -961, 178, 181, -453, -450, x, y, z)){
			checkpoints[48] = true;
			rplayer.setElytraCheckpoint(48);
		}
		else if(checkpoints[48] && !checkpoints[49] && Utils.isIn(-986, -983, 192, 195, -437, -434, x, y, z)){
			checkpoints[49] = true;
			rplayer.setElytraCheckpoint(49);
		}
		else if(checkpoints[49] && !checkpoints[50] && Utils.isIn(-972, -966, 196, 202, -405, -402, x, y, z)){
			checkpoints[50] = true;
			rplayer.setElytraCheckpoint(50);
		}
		else if(checkpoints[50] && !checkpoints[51] && Utils.isIn(-983, -980, 195, 198, -375, -372, x, y, z)){
			checkpoints[51] = true;
			rplayer.setElytraCheckpoint(51);
		}
		else if(checkpoints[51] && !checkpoints[52] && Utils.isIn(-1009, -1006, 197, 200, -384, -381, x, y, z)){
			checkpoints[52] = true;
			rplayer.setElytraCheckpoint(52);
		}
		else if(checkpoints[52] && !checkpoints[53] && Utils.isIn(-1013, -1010, 206, 209, -408, -405, x, y, z)){
			checkpoints[53] = true;
			rplayer.setElytraCheckpoint(53);
		}
		else if(checkpoints[53] && !checkpoints[54] && Utils.isIn(-1009, -1006, 183, 186, -443, -440, x, y, z)){
			checkpoints[54] = true;
			rplayer.setElytraCheckpoint(54);
		}
		else if(checkpoints[54] && !checkpoints[55] && Utils.isIn(-1030, -1027, 170, 173, -478, -475, x, y, z)){
			checkpoints[55] = true;
			rplayer.setElytraCheckpoint(55);
		}
		else if(checkpoints[55] && !checkpoints[56] && Utils.isIn(-1052, -1049, 176, 179, -457, -454, x, y, z)){
			checkpoints[56] = true;
			rplayer.setElytraCheckpoint(56);
		}
		else if(checkpoints[56] && !checkpoints[57] && Utils.isIn(-1052, -1049, 176, 179, -442, -439, x, y, z)){
			checkpoints[57] = true;
			rplayer.setElytraCheckpoint(57);
		}
		else if(checkpoints[57] && !checkpoints[58] && Utils.isIn(-1053, -1050, 181, 183, -406, -404, x, y, z)){
			checkpoints[58] = true;
			rplayer.setElytraCheckpoint(58);
		}
		else if(checkpoints[58] && !checkpoints[59] && Utils.isIn(-1072, -1069, 169, 171, -375, -373, x, y, z)){
			checkpoints[59] = true;
			rplayer.setElytraCheckpoint(59);
		}
		else if(checkpoints[59] && !checkpoints[60] && Utils.isIn(-1050, -1047, 169, 171, -358, -356, x, y, z)){
			checkpoints[60] = true;
			rplayer.setElytraCheckpoint(60);
		}
		else if(checkpoints[60] && !checkpoints[61] && Utils.isIn(-1064, -1061, 153, 156, -340, -337, x, y, z)){
			checkpoints[61] = true;
			rplayer.setElytraCheckpoint(61);
		}
		else if(checkpoints[61] && !checkpoints[62] && Utils.isIn(-1062, -1059, 184, 187, -310, -307, x, y, z)){
			checkpoints[62] = true;
			rplayer.setElytraCheckpoint(62);
		}
		else if(checkpoints[62] && !checkpoints[63] && Utils.isIn(-1064, -1061, 193, 195, -271, -269, x, y, z)){
			checkpoints[63] = true;
			rplayer.setElytraCheckpoint(63);
		}
		else if(checkpoints[63] && !checkpoints[64] && Utils.isIn(-1077, -1074, 192, 194, -246, -244, x, y, z)){
			checkpoints[64] = true;
			rplayer.setElytraCheckpoint(64);
		}
		else if(checkpoints[64] && !checkpoints[65] && Utils.isIn(-1043, -1040, 193, 195, -221, -219, x, y, z)){
			checkpoints[65] = true;
			rplayer.setElytraCheckpoint(65);
		}
		else if(checkpoints[65] && !checkpoints[66] && Utils.isIn(-1018, -1015, 185, 187, -219, -217, x, y, z)){
			checkpoints[66] = true;
			rplayer.setElytraCheckpoint(66);
		}
		else if(checkpoints[66] && !checkpoints[67] && Utils.isIn(-1001, -998, 185, 187, -219, -217, x, y, z)){
			checkpoints[67] = true;
			rplayer.setElytraCheckpoint(67);
		}
		else if(checkpoints[67] && !checkpoints[68] && Utils.isIn(-965, -962, 186, 188, -237, -235, x, y, z)){
			checkpoints[68] = true;
			rplayer.setElytraCheckpoint(68);
		}
		else if(checkpoints[68] && !checkpoints[69] && Utils.isIn(-892, -889, 188, 190, -277, -275, x, y, z)){
			checkpoints[69] = true;
			rplayer.setElytraCheckpoint(69);
		}
		else if(checkpoints[69] && !checkpoints[70] && Utils.isIn(-833, -830, 191, 197, -255, -249, x, y, z)){
			checkpoints[70] = true;
			rplayer.setElytraCheckpoint(70);
		}
	}
	
}
