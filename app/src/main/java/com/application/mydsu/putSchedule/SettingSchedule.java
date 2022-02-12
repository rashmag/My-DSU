package com.application.mydsu.putSchedule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class SettingSchedule {
    private SharedPreferences prefs;
    EditText[] editTexts = new EditText[252];
    String[] strMas;
    Context context;


    public SettingSchedule(Context context, EditText editTextLesson11, EditText editTextLesson12, EditText editTextLesson13, EditText editTextLesson14, EditText editTextLesson15, EditText editTextLesson16,
                           EditText editTextAuditores11,
                           EditText editTextAuditores12, EditText editTextAuditores13, EditText editTextAuditores14, EditText editTextAuditores15, EditText editTextAuditores16,
                            EditText editTextTeacher11, EditText editTextTeacher12,EditText editTextTeacher13, EditText editTextTeacher14, EditText editTextTeacher15, EditText editTextTeacher16,
                           EditText editTextLesson21, EditText editTextLesson22, EditText editTextLesson23, EditText editTextLesson24,
                           EditText editTextLesson25, EditText editTextLesson26,
                           EditText editTextAuditores21, EditText editTextAuditores22, EditText editTextAuditores23, EditText editTextAuditores24, EditText editTextAuditores25, EditText editTextAuditores26,
                           EditText editTextTeacher21, EditText editTextTeacher22,
                           EditText editTextTeacher23, EditText editTextTeacher24, EditText editTextTeacher25, EditText editTextTeacher26,
                           EditText editTextLesson31, EditText editTextLesson32, EditText editTextLesson33, EditText editTextLesson34,
                           EditText editTextLesson35, EditText editTextLesson36,
                           EditText editTextAuditores31, EditText editTextAuditores32, EditText editTextAuditores33, EditText editTextAuditores34, EditText editTextAuditores35, EditText editTextAuditores36,
                           EditText editTextTeacher31, EditText editTextTeacher32,
                           EditText editTextTeacher33, EditText editTextTeacher34, EditText editTextTeacher35, EditText editTextTeacher36,
                           EditText editTextLesson41, EditText editTextLesson42, EditText editTextLesson43, EditText editTextLesson44,
                           EditText editTextLesson45, EditText editTextLesson46,
                           EditText editTextAuditores41, EditText editTextAuditores42, EditText editTextAuditores43, EditText editTextAuditores44, EditText editTextAuditores45, EditText editTextAuditores46,
                           EditText editTextTeacher41, EditText editTextTeacher42,
                           EditText editTextTeacher43, EditText editTextTeacher44, EditText editTextTeacher45, EditText editTextTeacher46,
                           EditText editTextLesson51, EditText editTextLesson52, EditText editTextLesson53, EditText editTextLesson54,
                           EditText editTextLesson55, EditText editTextLesson56,
                           EditText editTextAuditores51, EditText editTextAuditores52, EditText editTextAuditores53, EditText editTextAuditores54, EditText editTextAuditores55, EditText editTextAuditores56,
                           EditText editTextTeacher51, EditText editTextTeacher52,
                           EditText editTextTeacher53, EditText editTextTeacher54, EditText editTextTeacher55, EditText editTextTeacher56,
                           EditText editTextLesson61, EditText editTextLesson62, EditText editTextLesson63, EditText editTextLesson64, EditText editTextLesson65, EditText editTextLesson66,
                           EditText editTextAuditores61, EditText editTextAuditores62, EditText editTextAuditores63, EditText editTextAuditores64, EditText editTextAuditores65, EditText editTextAuditores66,
                           EditText editTextTeacher61, EditText editTextTeacher62,
                           EditText editTextTeacher63, EditText editTextTeacher64, EditText editTextTeacher65, EditText editTextTeacher66,
                           EditText editTextLesson81, EditText editTextLesson82, EditText editTextLesson83, EditText editTextLesson84, EditText editTextLesson85, EditText editTextLesson86,
                           EditText editTextAuditores81, EditText editTextAuditores82, EditText editTextAuditores83, EditText editTextAuditores84, EditText editTextAuditores85, EditText editTextAuditores86,
                           EditText editTextTeacher81, EditText editTextTeacher82,
                           EditText editTextTeacher83, EditText editTextTeacher84, EditText editTextTeacher85, EditText editTextTeacher86,
                           EditText editTextLesson91, EditText editTextLesson92, EditText editTextLesson93, EditText editTextLesson94, EditText editTextLesson95, EditText editTextLesson96,
                           EditText editTextAuditores91, EditText editTextAuditores92, EditText editTextAuditores93, EditText editTextAuditores94, EditText editTextAuditores95, EditText editTextAuditores96,
                           EditText editTextTeacher91, EditText editTextTeacher92,
                           EditText editTextTeacher93, EditText editTextTeacher94, EditText editTextTeacher95, EditText editTextTeacher96,
                           EditText editTextLesson101, EditText editTextLesson102, EditText editTextLesson103, EditText editTextLesson104,
                           EditText editTextLesson105, EditText editTextLesson106,
                           EditText editTextAuditores101, EditText editTextAuditores102, EditText editTextAuditores103, EditText editTextAuditores104, EditText editTextAuditores105, EditText editTextAuditores106,
                           EditText editTextTeacher101, EditText editTextTeacher102,EditText editTextTeacher103,EditText editTextTeacher104,EditText editTextTeacher105,EditText editTextTeacher106,
                           EditText editTextLesson111, EditText editTextLesson112, EditText editTextLesson113, EditText editTextLesson114,
                           EditText editTextLesson115, EditText editTextLesson116,
                           EditText editTextAuditores111, EditText editTextAuditores112, EditText editTextAuditores113, EditText editTextAuditores114, EditText editTextAuditores115, EditText editTextAuditores116,
                           EditText editTextTeacher111, EditText editTextTeacher112,
                           EditText editTextTeacher113, EditText editTextTeacher114, EditText editTextTeacher115, EditText editTextTeacher116,
                           EditText editTextLesson121, EditText editTextLesson122, EditText editTextLesson123, EditText editTextLesson124,
                           EditText editTextLesson125, EditText editTextLesson126,
                           EditText editTextAuditores121, EditText editTextAuditores122, EditText editTextAuditores123, EditText editTextAuditores124, EditText editTextAuditores125, EditText editTextAuditores126,
                           EditText editTextTeacher121, EditText editTextTeacher122,
                           EditText editTextTeacher123, EditText editTextTeacher124, EditText editTextTeacher125, EditText editTextTeacher126,EditText editTextLesson131, EditText editTextLesson132, EditText editTextLesson133, EditText editTextLesson134,
                           EditText editTextLesson135, EditText editTextLesson136,EditText editTextAuditores131, EditText editTextAuditores132, EditText editTextAuditores133, EditText editTextAuditores134, EditText editTextAuditores135, EditText editTextAuditores136,
                           EditText editTextTeacher131, EditText editTextTeacher132,
                           EditText editTextTeacher133, EditText editTextTeacher134, EditText editTextTeacher135, EditText editTextTeacher136) {


        this.prefs = context.getSharedPreferences("FirstRun", MODE_PRIVATE);

        this.context = context;
        this.editTexts[0] = editTextLesson11;
        this.editTexts[1] = editTextAuditores11;
        this.editTexts[2] = editTextTeacher11;

        this.editTexts[3] = editTextLesson12;
        this.editTexts[4] = editTextAuditores12;
        this.editTexts[5] = editTextTeacher12;

        this.editTexts[6] = editTextLesson13;
        this.editTexts[7] = editTextAuditores13;
        this.editTexts[8] = editTextTeacher13;

        this.editTexts[9] = editTextLesson14;
        this.editTexts[10] = editTextAuditores14;
        this.editTexts[11] = editTextTeacher14;

        this.editTexts[12] = editTextLesson15;
        this.editTexts[13] = editTextAuditores15;
        this.editTexts[14] = editTextTeacher15;

        this.editTexts[15] = editTextLesson16;
        this.editTexts[16] = editTextAuditores16;
        this.editTexts[17] = editTextTeacher16;

        this.editTexts[18] = editTextLesson21;
        this.editTexts[19] = editTextAuditores21;
        this.editTexts[20] = editTextTeacher21;

        this.editTexts[21] = editTextLesson22;
        this.editTexts[22] = editTextAuditores22;
        this.editTexts[23] = editTextTeacher22;

        this.editTexts[24] = editTextLesson23;
        this.editTexts[25] = editTextAuditores23;
        this.editTexts[26] = editTextTeacher23;

        this.editTexts[27] = editTextLesson24;
        this.editTexts[28] = editTextAuditores24;
        this.editTexts[29] = editTextTeacher24;

        this.editTexts[30] = editTextLesson25;
        this.editTexts[31] = editTextAuditores25;
        this.editTexts[32] = editTextTeacher25;

        this.editTexts[33] = editTextLesson26;
        this.editTexts[34] = editTextAuditores26;
        this.editTexts[35] = editTextTeacher26;

        this.editTexts[36] = editTextLesson31;
        this.editTexts[37] = editTextAuditores31;
        this.editTexts[38] = editTextTeacher31;

        this.editTexts[39] = editTextLesson32;
        this.editTexts[40] = editTextAuditores32;
        this.editTexts[41] = editTextTeacher32;

        this.editTexts[42] = editTextLesson33;
        this.editTexts[43] = editTextAuditores33;
        this.editTexts[44] = editTextTeacher33;

        this.editTexts[45] = editTextLesson34;
        this.editTexts[46] = editTextAuditores34;
        this.editTexts[47] = editTextTeacher34;

        this.editTexts[48] = editTextLesson35;
        this.editTexts[49] = editTextAuditores35;
        this.editTexts[50] = editTextTeacher35;

        this.editTexts[51] = editTextLesson36;
        this.editTexts[52] = editTextAuditores36;
        this.editTexts[53] = editTextTeacher36;

        this.editTexts[54] = editTextLesson41;
        this.editTexts[55] = editTextAuditores41;
        this.editTexts[56] = editTextTeacher41;

        this.editTexts[57] = editTextLesson42;
        this.editTexts[58] = editTextAuditores42;
        this.editTexts[59] = editTextTeacher42;

        this.editTexts[60] = editTextLesson43;
        this.editTexts[61] = editTextAuditores43;
        this.editTexts[62] = editTextTeacher43;

        this.editTexts[63] = editTextLesson44;
        this.editTexts[64] = editTextAuditores44;
        this.editTexts[65] = editTextTeacher44;

        this.editTexts[66] = editTextLesson45;
        this.editTexts[67] = editTextAuditores45;
        this.editTexts[68] = editTextTeacher45;

        this.editTexts[69] = editTextLesson46;
        this.editTexts[70] = editTextAuditores46;
        this.editTexts[71] = editTextTeacher46;

        this.editTexts[72] = editTextLesson51;
        this.editTexts[73] = editTextAuditores51;
        this.editTexts[74] = editTextTeacher51;

        this.editTexts[75] = editTextLesson52;
        this.editTexts[76] = editTextAuditores52;
        this.editTexts[77] = editTextTeacher52;

        this.editTexts[78] = editTextLesson53;
        this.editTexts[79] = editTextAuditores53;
        this.editTexts[80] = editTextTeacher53;

        this.editTexts[81] = editTextLesson54;
        this.editTexts[82] = editTextAuditores54;
        this.editTexts[83] = editTextTeacher54;

        this.editTexts[84] = editTextLesson55;
        this.editTexts[85] = editTextAuditores55;
        this.editTexts[86] = editTextTeacher55;

        this.editTexts[87] = editTextLesson56;
        this.editTexts[88] = editTextAuditores56;
        this.editTexts[89] = editTextTeacher56;

        this.editTexts[90] = editTextLesson61;
        this.editTexts[91] = editTextAuditores61;
        this.editTexts[92] = editTextTeacher61;

        this.editTexts[93] = editTextLesson62;
        this.editTexts[94] = editTextAuditores62;
        this.editTexts[95] = editTextTeacher62;

        this.editTexts[96] = editTextLesson63;
        this.editTexts[97] = editTextAuditores63;
        this.editTexts[98] = editTextTeacher63;

        this.editTexts[99] = editTextLesson64;
        this.editTexts[100] = editTextAuditores64;
        this.editTexts[101] = editTextTeacher64;

        this.editTexts[102] = editTextLesson65;
        this.editTexts[103] = editTextAuditores65;
        this.editTexts[104] = editTextTeacher65;

        this.editTexts[105] = editTextLesson66;
        this.editTexts[106] = editTextAuditores66;
        this.editTexts[107] = editTextTeacher66;


        this.editTexts[108] = editTextLesson81;
        this.editTexts[109] = editTextAuditores81;
        this.editTexts[110] = editTextTeacher81;

        this.editTexts[111] = editTextLesson82;
        this.editTexts[112] = editTextAuditores82;
        this.editTexts[113] = editTextTeacher82;

        this.editTexts[114] = editTextLesson83;
        this.editTexts[115] = editTextAuditores83;
        this.editTexts[116] = editTextTeacher83;

        this.editTexts[117] = editTextLesson84;
        this.editTexts[118] = editTextAuditores84;
        this.editTexts[119] = editTextTeacher84;

        this.editTexts[120] = editTextLesson85;
        this.editTexts[121] = editTextAuditores85;
        this.editTexts[122] = editTextTeacher85;

        this.editTexts[123] = editTextLesson86;
        this.editTexts[124] = editTextAuditores86;
        this.editTexts[125] = editTextTeacher86;

        this.editTexts[126] = editTextLesson91;
        this.editTexts[127] = editTextAuditores91;
        this.editTexts[128] = editTextTeacher91;

        this.editTexts[129] = editTextLesson92;
        this.editTexts[130] = editTextAuditores92;
        this.editTexts[131] = editTextTeacher92;

        this.editTexts[132] = editTextLesson93;
        this.editTexts[133] = editTextAuditores93;
        this.editTexts[134] = editTextTeacher93;

        this.editTexts[135] = editTextLesson94;
        this.editTexts[136] = editTextAuditores94;
        this.editTexts[137] = editTextTeacher94;

        this.editTexts[138] = editTextLesson95;
        this.editTexts[139] = editTextAuditores95;
        this.editTexts[140] = editTextTeacher95;

        this.editTexts[141] = editTextLesson96;
        this.editTexts[142] = editTextAuditores96;
        this.editTexts[143] = editTextTeacher96;

        this.editTexts[144] = editTextLesson101;
        this.editTexts[145] = editTextAuditores101;
        this.editTexts[146] = editTextTeacher101;

        this.editTexts[147] = editTextLesson102;
        this.editTexts[148] = editTextAuditores102;
        this.editTexts[149] = editTextTeacher102;

        this.editTexts[150] = editTextLesson103;
        this.editTexts[151] = editTextAuditores103;
        this.editTexts[152] = editTextTeacher103;

        this.editTexts[153] = editTextLesson104;
        this.editTexts[154] = editTextAuditores104;
        this.editTexts[155] = editTextTeacher104;

        this.editTexts[156] = editTextLesson105;
        this.editTexts[157] = editTextAuditores105;
        this.editTexts[158] = editTextTeacher105;

        this.editTexts[159] = editTextLesson106;
        this.editTexts[160] = editTextAuditores106;
        this.editTexts[161] = editTextTeacher106;


        this.editTexts[162] = editTextLesson111;
        this.editTexts[163] = editTextAuditores111;
        this.editTexts[164] = editTextTeacher111;

        this.editTexts[165] = editTextLesson112;
        this.editTexts[166] = editTextAuditores112;
        this.editTexts[167] = editTextTeacher112;

        this.editTexts[168] = editTextLesson113;
        this.editTexts[169] = editTextAuditores113;
        this.editTexts[170] = editTextTeacher113;

        this.editTexts[171] = editTextLesson114;
        this.editTexts[172] = editTextAuditores114;
        this.editTexts[173] = editTextTeacher114;

        this.editTexts[174] = editTextLesson115;
        this.editTexts[175] = editTextAuditores115;
        this.editTexts[176] = editTextTeacher115;

        this.editTexts[177] = editTextLesson116;
        this.editTexts[178] = editTextAuditores116;
        this.editTexts[179] = editTextTeacher116;

        this.editTexts[180] = editTextLesson121;
        this.editTexts[181] = editTextAuditores121;
        this.editTexts[182] = editTextTeacher121;

        this.editTexts[183] = editTextLesson122;
        this.editTexts[184] = editTextAuditores122;
        this.editTexts[185] = editTextTeacher122;

        this.editTexts[186] = editTextLesson123;
        this.editTexts[187] = editTextAuditores123;
        this.editTexts[188] = editTextTeacher123;

        this.editTexts[189] = editTextLesson124;
        this.editTexts[190] = editTextAuditores124;
        this.editTexts[191] = editTextTeacher124;

        this.editTexts[192] = editTextLesson125;
        this.editTexts[193] = editTextAuditores125;
        this.editTexts[194] = editTextTeacher125;

        this.editTexts[195] = editTextLesson126;
        this.editTexts[196] = editTextAuditores126;
        this.editTexts[197] = editTextTeacher126;

        this.editTexts[198] = editTextLesson131;
        this.editTexts[199] = editTextAuditores131;
        this.editTexts[200] = editTextTeacher131;

        this.editTexts[201] = editTextLesson132;
        this.editTexts[202] = editTextAuditores132;
        this.editTexts[203] = editTextTeacher132;

        this.editTexts[204] = editTextLesson133;
        this.editTexts[205] = editTextAuditores133;
        this.editTexts[206] = editTextTeacher133;

        this.editTexts[207] = editTextLesson134;
        this.editTexts[208] = editTextAuditores134;
        this.editTexts[209] = editTextTeacher134;

        this.editTexts[210] = editTextLesson135;
        this.editTexts[211] = editTextAuditores135;
        this.editTexts[212] = editTextTeacher135;

        this.editTexts[213] = editTextLesson136;
        this.editTexts[214] = editTextAuditores136;
        this.editTexts[215] = editTextTeacher136;
    }

    @SuppressLint("SetTextI18n")
    public void setTextOnEdit(){
        for (int i = 0; i < 216; i++) {
            editTexts[i].setText(strMas[i]);
        }
    }
    //1 КУРС ФИИИТ
    public void courseOneISiT() {
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                "ДРИ / Ин. яз.", "(1 п/г), библ.ПО / (2п/г) 4.17", "Ахмедова З.Х. / Мутаева С.И.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Физика", "3.14 л.", "Гусейханов М.К.",
                //2 пара:
                "ДР/инф. л.", "2.1", "Ахмедова З.Х.",
                //3 пара:
                "Прогр.яз ВУ пр.", "Прогр.яз ВУ пр.", "2.1",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "К/практ", "(1,2 п/г) 2.9, 2.11", "Ахмедов С.А. / Муртузалиева А.А.",
                //2 пара:
                "Мат. анализ пр.", "3.14", "Магомедова В.Г.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "История л.", "3.14", "Сулаев И.Х.",
                //2 пара:
                "Информ. л.", "3.14", "Ахмедов С.А.",
                //3 пара:
                "Инф.", "(1,2п/г) 2.9, 2.11 ", "Ахмедов С.А. / Муртузалиева А.А.",
                //4 пара:
                "Физика", "1,2п/г лаб", "Магомедова У. / Гираев М.А.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Мат. анализ л.", "3.14","Магомедова В.Г.",
                //2 пара:
                "Физика пр.", "4.4", "Магомедова У.",
                //3 пара:
                "Ин.яз. / Прогр. на яз.ВУ", "(1п/г) 4.17 / (2п/г) библ. МИЦ ", "Мутаева С.И. / Ахмедова З.Х.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",


// 2 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                "ДРИ. л/р", "2 п/г", "библ.ПО  Ахмедова З.Х.",
                //3 пара:
                "Ин.яз.", "1п/г 4.8", "Мутаева С.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Мутаева С.И.", "2.1", "Гусейханов М.К.",
                //2 пара:
                "Прогр. на ЯВУ л.", "3.14", "Ахмедова З.Х.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Комп. пр.", "(1,2 п/г) / 2.9, 2.11", "Ахмедов С.А.",
                //2 пара:
                "Мат. анализ пр. ", "4.13", "Магомедова В.Г.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "История пр.", "3.14", "Сулаев И.Х.",
                //2 пара:
                "Инф-ка пр.", "2.1 ", "Муртузалиева А.А.",
                //3 пара:
                "Информ.", "(1,2п/г) / 2.9,2.11", "Ахмедов С.А. / Муртузалиева А.А.",
                //4 пара:
                "Физика", "1,2п/г лаб", "Магомедова У. / Гираев М.А.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Мат. анализ л. ", "4.4", "Магомедова В.Г. ",
                //2 пара:
                "Физика пр.", "4.4", "Магомедова У.",
                //3 пара:
                "Прогр. на яз.ВУ", "1п/г библ.ПО / 4.17 2п/г", "Ахмедова З.Х. / Ин.яз. Мутаева С.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", false).commit();

        setTextOnEdit();

    }
    public void courseOneIB(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "Физика л.", "3.14", "Гусейханов М.К.",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Мат. анализ л.", "4.13", "Амучиева Т.С.",
                //2 пара:
                "Мат. анализ пр.", "4.13", "Амучиева Т.С.",
                //3 пара:
                "Инф. техн. л.", "4.13 ", "Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Физ практ.", "(1,2п/г) (физ. фак)", "Гираев М.А. / Магомедова У.",
                //2 пара:
                "Ап. сред. ВТ л.", "4.13", "Гаджиев Т.С.",
                //3 пара:
                "Ин.яз. /  ИТ", "(1п/г) 4.17 / (2п/г) 2.9", "Мутаева С.И. / Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "ЧМиМП", "4.13  пр.", "Гаджиева Т.",
                //2 пара:
                "Осн. ИБ л.", "4.13", "Бакмаев А.Ш.",
                //3 пара:
                "Проф. этика л.", "4.13", "Абакарова Р.М.",
                //4 пара:
                "Электротехника л.", "4.13", "Шабанов Ш.Ш.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Яз. прогр. л/р / Ин.яз.", "(1п/г)  библ.ПО / (2п/г) 4.17 ", "Ахмедова З.Х. / Мутаева С.И.",
                //2 пара:
                "ЧМиМП", "4.13 л.", "Гаджиева Т.Ю",
                //3 пара:
                "ЧМиМП л/р", "(1п/г) 2.11", "Гаджиева Т. Ю.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",


// 2 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                "Физика", "3.14", "Гусейханов М.К. ",
                //3 пара:
                " Физика практ", "2.1", " Физика практ ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " Мат. анализ пр.", "4.13", " Амучиева Т.С.",
                //2 пара:
                "Мат. анализ л.", " 4.13 ", " Амучиева Т.С. ",
                //3 пара:
                " Яз. прогр.", " 4.13", " Ахмедова З.Х.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " Физ практ.", " 1,2п/г (физ. )", " Магомедова У. / Гираев М.А. ",
                //2 пара:
                " Апп. ср. ВТ", " 4.17  пр.", " Гаджиев Т.С.",
                //3 пара:
                " ИТ", " 1п/г 2.10", "Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " Ин.яз.", " 2п/г 4.17", " Мутаева С.И. ",
                //2 пара:
                " Осн. ИБ пр.", "2.15", " Бакмаев А.Ш.",
                //3 пара:
                "Проф. этика пр.", " 4.7", " Абакарова Р.М. пр.",
                //4 пара:
                " Электротехника ", " 4.13 пр.", " Шабанов Ш.Ш. ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " Ин.яз. / Яз. прогр.", " 1п/г 4.17 / 2п/г библ.ПО ", " Мутаева С. / Ахмедова З.Х",
                //2 пара:
                " Ахмедова З.Х", " 2.1 л.", " Гаджиева Т",
                //3 пара:
                " ЧМиМП л/р ", "2.11 (2п/г)", " Гаджиева Т.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", false).commit();


        setTextOnEdit();

    }
    public void courseOneISiP(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                "ВССТ л/р / ТАиОД", "1п/г 2.3 / 2п/г б/МИЦ", "Шахбанова З.И. / Абдурахм-а З.М.",
                //3 пара:
                "Кураторский час", "4.6", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "К/практ л/р", "1п/г  Библ МИЦ", "Касимова Т.М.",
                //2 пара:
                "ТАиОД л/р / К/практ л/р", "1п/г Библ ПО / 2п/г библ ПО", "Абдурахм-а З.М. / Касимова Т.М.  ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Инф.", "1п/г Библ МИЦ ", "Абдурахманова З.",
                //2 пара:
                "ВССиТ л.", "4.16", "Нурмагомедов Ш.А.",
                //3 пара:
                "Диск.мат. пр.", "4.13", "Рагимханов В.Р.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "Информатика и программирование л.", "4.16", "Абдурахманова З.М.",
                //2 пара:
                "Ин.яз", "(1,2п/г), 4.17, 4.8 ", "Ризаханова З.З. / Гаджиева С.А.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                "ИСиТ / ВССТ л/р", "(1п/г) 2.9 / (2п/г) 2.3", "Гаирбекова П.И. / Шахбанова З.И.",
                //3 пара:
                "Экон.теория л.", "4.16", "Аликеримова Т.Д",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Математика пр.", "4.16", "Амучиева Т.",
                //2 пара:
                "Математика пр.", "4.16", "Амучиева Т.",
                //3 пара:
                "Эк.теор пр.", "4.16", "Аликеримова Т.Д",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " Физкультура", " ", " ",
                //2 пара:
                " Технологии анализа и обработки данных л.", " 4.16 ", " Абдурахманова З.М. ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ИСиТ пр.", " 4.16", " Гаирбекова П.И.",
                //2 пара:
                " Информационные системы и технологии л.", "4.16", " Камилов М.-К.Б.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " К/практ л/р", " 2п/г библ.МИЦ ", " Касимова Т.М ",
                //2 пара:
                " Дискретная математика л.", " 4.6", " Рагимханов В.Р.",
                //3 пара:
                "Дискр.мат. пр.", "4.6", " Рагимханов В.Р. ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " К/практ л/р / ВССТ л/р ", " (1п/г) библ. МИЦ / (2п/г) 2.3", " Касимова Т.М. / Шахбанова З.И.",
                //2 пара:
                " ВССТ л/р / ТАиОД", " (1п/г) 2.9 / (2п/г) библ.МИЦ ", " Шахбанова З.И. / Абдурахм-а З.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ВССиТ пр.", " 4.13 ", " Шахбанова З.И.",
                //2 пара:
                "ТАиОД л/р / ИСиТ", "(1п/г) библ. МИЦ / (2п/г) 2.9  ", " Абдурахм-а З.М. / Гаирбекова П.И.",
                //3 пара:
                " Ин.яз", " 1,2п/г 4.8, 4.4", " Ризаханова З.З., Гаджиева С.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " Математика пр.", "4.6", " Амучиева Т.",
                //2 пара:
                " Математика", "4.6", "Амучиева Т.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();
// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();

    }
    public void courseOnePIE(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                "Ин.яз.", "(1,2 п/г) / 4.8, 4.4 ", "Абдуллаева М.И. / Билалова Х.А.",
                //3 пара:
                "Кураторский час", "2.1", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "ВССТ л/р", "2п/г 2.3", "Шахбанова З.И.",
                //2 пара:
                "ВССиТ пр.", "4.4", "Шахбанова З.И.",
                //3 пара:
                "ИСиТ", "1п/г 2.11", "Гаирбекова П.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "ВССиТ л.", "4.16", "Нурмагомедов Ш.А.",
                //2 пара:
                "Эк.теория пр.", "4.4", "Аликеримова Т.Д",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " Информатика и программирование л.", "4.16", "Абдурахманова З.М.",
                //2 пара:
                "ТАиОД л/р / Инф.", "(1п/г)  Б/МИЦ / (2п/г) 2.3", "Абдурахм-а З.М. / Баммаева Г.А.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "ВССТ л/р / ТАиОД л/р", "(1п/г) 2.3 / (2п/г) Библ МИЦ", "Шахбанова З.И. / Абдурахманова З.М. ",
                //2 пара:
                "Дискр. матем. Пр.", "2.1", "Джабраилова Л.М.",
                //3 пара:
                "Экон.теория л.", "Аликеримова Т.Д", "4.16",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Разр.прил. в  MS Office", "4.4", "Исаибова Д.И.",
                //2 пара:
                "Математика л.", "4.16", "Амучиева Т.",
                //3 пара:
                "Математика пр.", "4.13", "Амучиева Т.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
// 2 неделя
                // Понедельник, 1 пара:
                "Физкультура", " ", " ",
                //2 пара:
                " Технологии анализа и обработки данных л.", "4.16", "Абдурахманова З.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "ТАиОД л/р", " (1п/г)  библ.МИЦ / (2п/г) 2.3 ", " Абдурахм-а З.М. / Абдурахм-а З.М.",
                //2 пара:
                " Информационные системы и технологии л.", "4.16", " Камилов М.-К.Б.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " Дискретная математика л.", "4.6", "Рагимханов В.Р.",
                //3 пара:
                "Ин.яз.", "(1,2 п/г)  4.8, 4.17 ", "Абдуллаева М.И., Билалова Х.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "ТАиОД", "2п/г библ.ПО", "Абдурахм-а З.М.",
                //2 пара:
                "Инф. / ИСиТ", "(1п/г) 2.10 / (2п/г) 2.3", "Баммаева Г.А. / Гаирбекова П.И.",
                //3 пара:
                " ВССТ л/р", "(1п/г) 2.3 ", " Шахбанова З.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ИСиТ пр.", "2.15", " Гаирбекова П.И.",
                //2 пара:
                "Дискр. матем. пр.", "2.15", "Джабраилова Л.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " РП MS Office", "4.17", "Исаибова Д.И.",
                //2 пара:
                "Математика", "4.6", " Амучиева Т.",
                //3 пара:
                "Математика", "4.6", " Амучиева Т.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();

    }
    //2 КУРС ФИИИТ
    public void courseTwoISiT(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "ИТ", "1п/г ВЦ", "Гаджиев А.М.",
                //2 пара:
                "И/техн.", " 4.13 л.", "Гаджиев А.М.",
                //3 пара:
                "Проф.ин.яз. / ИТ", "(1 п/г), 4.17 / (2п/г), 2.11", "Мутаева С. / Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "ОС / ООП", "(1п/г) 2.12 / (2п/г) 2.9", "Бакмаев А.Ш. / Бабаева К. А.",
                //2 пара:
                "Правоведение", "3.14", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Философия пр.", "2.15", " Саркарова Н.А.",
                //2 пара:
                "Философия пр.", "2.15", " Саркарова Н.А.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "К/геом и граф. / ОС", "(1п/г) 2.11 / (2п/г) 2.12", "Гаджиев А.М. / Бакмаев А.Ш.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Проф.ин.яз. / Т/прогр", "(1п/г) 4.17 / 2.11  (2п/г)", "Мутаева С. / Исмиханов З.Н.",
                //2 пара:
                "Техн. прогр-ия л.", "3.14", "Исмиханов З.Н.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
// 2 неделя
                // Понедельник, 1 пара:
                "ИТ", "(2п/г), ВЦ", "Гаджиев А.М.",
                //2 пара:
                "Инф.техн.", "4.4 пр.", "Гаджиев А.М.",
                //3 пара:
                "Проф.ин.яз. / ИТ", "(2 п/г) 4.17 / (1п/г), ВЦ", "Мутаева С. / Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Техн. прогр-ия пр.", "3.14", "Исмиханов З.Н.",
                //2 пара:
                "ООП / OC", "(1п/г) 2.11 / (2п/г) 2.12", "Магомедов М.Р. / Бакмаев А.Ш.",
                //3 пара:
                "Опер. сист. л.", "3.14", "Бакмаев А.Ш.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Философия л.", "3.14", "Саркарова Н.А.",
                //2 пара:
                "К/геом и граф. л.", "3.14", "Гаджиев А.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "ОС / К/геом и гр.", "(1п/г) 2.12 / (2п/г) 2.11", "Бакмаев А.Ш. / Гаджиев А.М.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                "ООП л.", "2,15", "Баммаева Г.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Проф.ин.яз. / Т/прогр.", "(1 п/г) 4,17 / (2 п/г) 2.11", "Мутаева С. / Исмиханов З.Н.",
                //3 пара:
                "Правовед.", "3.14", "Гаджиев А.Ш.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Экономика л.", "4.4", "Аликберова А.М.",
                //2 пара:
                "Экономика л.", "4.4", "Аликберова А.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();
    }
    public void courseTwoIB(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "Ин.яз.", "(1 п/г) 4.17", "Мутаева С.И.",
                //2 пара:
                "БЖД л.", "2.15", "Абдурахманова Э.Г.",
                //3 пара:
                "Орг. и прав. обесп. ИБ ", "4.13 л.", " Рагимханова К.Т.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " Яз.ассемб.", "(1п/г) 2.11", " Мустафаев А.Г.",
                //2 пара:
                " Электр. и схем.", "4.17", " Нурмагомедов Ш.А. ",
                //3 пара:
                " И/програм.", "4.17", " Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ТФКП л.", "2.1", " Магомедов Г.А.",
                //2 пара:
                " ТФКП л.", "2.1", " Магомедов Г.А.",
                //3 пара:
                "ТиМ прогр.", "(1п/г) 2.11", "Исабекова Т.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "Инт. Програм / Ин.яз.", "(1п/г) 2.9 / (2п/г) 4.8", "Ахмедова Н.М. / Мутаева С. И.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Языки ассемб.", "(2п/г) 2.11", "Мустафаев А.Г.",
                //2 пара:
                "Орг. и прав. обесп. ИБ", "2,15 пр.", "Рагимханова Д.А.",
                //3 пара:
                "Дискр. матем.", "2.15", "Ибрагимов М.Г.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Я/ ассемб", "2.15", "Мустафаев А.Г.",
                //2 пара:
                "ТВиМС", "2.15 л.", "Абдурагимов Г.Э.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
// 2 неделя
                // Понедельник, 1 пара:
                "Ин.яз.", "(2 п/г) 4.17", "Мутаева С.И.",
                //2 пара:
                "БЖД", "4.13 пр.", "Абдурахманова Э.Г.",
                //3 пара:
                "И/програм.", "4.13", "Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Яз.ассемб.", "(1п/г) 2.11", "Мустафаев А.Г.",
                //2 пара:
                "Интернет прогр.", "2.1", "Ахмедова Н.М.",
                //3 пара:
                "ТиМ прогр.", "(2п/г) 2.9", "Исабекова Т.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "ТФКП", "2.1 л.", "Магомедов Г.А.",
                //2 пара:
                "Электр. и схем.", "2.1", "Нурмагомедов Ш.А.",
                //3 пара:
                "Техн. и методы прогр.", "3.14 л.", "Исабекова Т.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "Инт.програм", "(2п/г) 2.9", "Магомедов М.Р.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                "Ин.яз.", "(1п/г) 4.17", "Мутаева С.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Яз.ассемб.", "(2п/г) 2.11", "Мустафаев А.Г.",
                //2 пара:
                "Орг. и прав. обесп. ИБ", "4,13 л.", "Рагимханова К.Т.",
                //3 пара:
                "Дискр. матем.", "4.13", "Ибрагимов М.Г.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "ТВиМС л.", "2.1", "Абдурагимов Г.Э.",
                //2 пара:
                "ТВиМС л.", "2.1", "Абдурагимов Г.Э.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();


    }
    public void courseTwoPIE(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "ИОиМО", "(1 п/г) 2,10", "М-гаджиев Ш.М.",
                //2 пара:
                "ИОиМО л.", "4,16", "М-Гаджиев Ш.М.",
                //3 пара:
                "ООП", "2п/г  Библ МИЦ", "Магомедова С.Р.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "ИОиМО", "(2 п/г) 2.10", "М-гаджиев Ш.М.",
                //2 пара:
                "Базы данных л.", "4,16", "Шахабудинов Я.М.",
                //3 пара:
                "Архит. п/п", "(1п/г) 2.9", "Рабаданова Р.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "ООП / ВЦ Архит. п/п ", "(1п/г) / (2п/г) 2.9", "Магомедова С.Р. / Рабаданова Р.М.",
                //3 пара:
                "Архитектура предприятий л.", "4.16", "Исмиханов З.Н.",
                //4 пара:
                "ИБ пр.", "4.16", "Гаджиев А.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "Архит. п/п пр.", "4.6", "Рабаданова Р.М.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                "Ин.яз", "(1,2 п/г) / (4.17, 4.8)", "Абдуллаева М.И. / Айгубова С.С.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                "ООП л.", "4.16", "Магомедова С.Р.",
                //3 пара:
                "БД / КМвЭк", "(1п/г) 2.9 / (2п/г)  2.10", "Шахабудинов Я.М. / Касимова Т.М.",
                //4 пара:
                "КМвЭк", "(1п/г) 2.10", "Касимова Т.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
// 2 неделя
                // Понедельник, 1 пара:
                "ИОиМО пр", "4.16", "М-Гаджиев Ш.М.",
                //2 пара:
                "ООП / ИОиМО", "(1п/г) библ.МИЦ / (2 п/г)  2.10", "Магомедова С.Р. / М-Гаджиев Ш.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "ИОиМО", "(1 п/г) 2.10", "М-гаджиев Ш.М.",
                //2 пара:
                " Инфор. Безо-ть л.", "4.6", "Гаджиев А.М.",
                //3 пара:
                "ИБ пр", "4.6", "Гаджиев А.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "Архит. п/п", "(1п/г) 2.10", "Рабаданова Р.М.",
                //2 пара:
                "Информатика и программирование л.", "4.16", "Гаджиев Н.К.",
                //3 пара:
                "ООП", "(2п/г) библ.МИЦ", "Магомедова С.Р.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "ИиП", "(1п/г) 2.10", "Мирзабеков Я.М.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                "Ин.яз", "(1,2 п/г) / (4.8, 4.4)", "Абдуллаева М.И. / Айгубова С.С.",
                //4 пара:
                "ИиП", "(2п/г) библ.МИЦ", "Мирзабеков Я.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "БД", "(1п/г) 2.9", "Шахабудинов Я.М.",
                //2 пара:
                "Комп. модел. в эконом. ", "4.16 л.", " Касимова Т.М.",
                //3 пара:
                " КМвЭк пр.", "2.15", " Касимова Т.М.",
                //4 пара:
                " Архит. п/п", " (2п/г) 2.9", " Рабаданова Р.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ООП пр.", "2.15", " Бабаева К. А.",
                //2 пара:
                " ИиП пр.", "2.15", " Мирзабеков Я.М.",
                //3 пара:
                " БД пр.", "4.16", " Шахабудинов Я.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();
    }
    public void courseTwoPIM(){
        strMas = new String[]{
// 1 неделя
                // Понедельник, 1 пара:
                "ИОиМО / Архит. п/п лаб.", "(1 п/г) 2.3 / (2п/г) 2.9", "Гасанова Н.Р. / Рабаданова Р.М.",
                //2 пара:
                "ИОиМО л.", "4.16", "М-Гаджиев Ш.М.",
                //3 пара:
                "Ин.яз", "(1,2 п/г) / (4.8, 4.4)", "Ризаханова З.З. / Гаджиева С.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "БД пр.", "4.16", "Шахабудинов Я.М.",
                //2 пара:
                "Базы данных л.", "4.16", "Шахабудинов Я.М.",
                //3 пара:
                "ООП", "(2п/г) 2.10", "Баммаева Г.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "ООП / ИОиМО ", "(1п/г) ВЦ / (2 п/г)  2.3", "Баммаева Г.А. / Гасанова Н.Р.",
                //2 пара:
                "ИБ пр.", "4.4", "ИБ пр.",
                //3 пара:
                "Архитектура предприятий л.", "4.16", "Исмиханов З.Н.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "ИиП / КМвЭк", "(1п/г) Библ МИЦ / (2п/г) 2.10", "Мирзабеков Я.М. / Касимова Т.М.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                "ИиП пр.", "2,15", "Мирзабеков Я.М.",
                //4 пара:
                "ИиП", "2п/г Библ МИЦ", "Мирзабеков Я.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "Архит. п/п лаб. / БД", "(1п/г) 2.9 / (2п/г) 2.11", "Рабаданова Р.М. / Шахабуд-в Я.М.",
                //2 пара:
                "ООП л.", "4.16", "Магомедова С.Р.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
// 2 неделя
                // Понедельник, 1 пара:
                " ООП / Архит. п/п лаб.", "(1п/г) 2.3 / (2п/г) 2.9", " Баммаева Г.А. / Рабаданова Р.М.",
                //2 пара:
                " Архит. п/п пр.", "2.1", " Рабаданова Р.М.",
                //3 пара:
                " Ин.яз", "( 1,2 п/г) / (4.8, 4.4)", " Ризаханова З.З. / Гаджиева С.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ИОиМО / БД", "(1 п/г)  2.3 / 2п/г ВЦ", " Гасанова Н.Р. / Шахабудинов Я.М.",
                //2 пара:
                " Инфор. Безо-ть л.", "4.6", " Гаджиев А.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                "ИБ пр.", "4.16", " Гаджиев А.М.",
                //2 пара:
                " Инф-ка и прогр-е л.", "4.16", " Гаджиев Н.К.",
                //3 пара:
                "ООП", "( 2п/г) 2.3", " Баммаева Г.А.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ИОиМО пр", "2.1", " М-Гаджиев Ш.М.",
                //2 пара:
                "Физкультура", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "КМвЭк / ИОиМО", "(1п/г) 2.10 / (2п/г) 2.3", " Касимова Т.М. / Гасанова Н.Р.",
                //2 пара:
                " Ком-ное модел-ние в эк-ке л.", "4.16", " Касимова Т.М.",
                //3 пара:
                " Архит. п/п ", "(1п/г) 2.3 ", " Рабаданова Р.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " КМвЭк пр.", "2.3", " Касимова Т.М. ",
                //2 пара:
                " ООП пр.", "2.3", "Магомедова С.Р.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();
    }
    //3 КУРС ФИИИТ
    public void courseThreeISiT(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Физкультура", "Спорткомплекс ДГУ", " ",
                //4 пара:
                "Web-технологии", "2.15", "Ахмедова Н. М.",
                //5 пара:
                "Архитектура ИС", "2 подгр., 2.11", "Ахмедова Н. М.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "МиСПИСиИТ", "2 подгр., ВЦ", "Магомедова С. Р.",
                //4 пара:
                "ИБ и ЗИ", "4.4", "Исабекова Т. И.",
                //5 пара:
                "ИБ и ЗИ (лаб.)", "1 подгр., 2.11", "Исабекова Т. И.",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Web-технологии", "1 подгр., ВЦ", "Ахмедова Н. М.",
                //4 пара:
                "Мультимедиа технологии", "4.13", "Гаджиев Т. С.",
                //5 пара:
                "Инструментальные ср-ва ИС", "4.13", "Рабаданова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "МиСПИСиИТ", "3.14", "Исмиханов З.Н .",
                //5 пара:
                "Цифровые сети", "4.17", "Муталов М.С.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Инструментальные ср-ва ИС", "4.13", "Рабаданова Р. М.",
                //4 пара:
                "Теория ИП", "4.4", "Рабаданова Р. М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Рус. и даг. лит-ра", "4.6", "Ширванова Э. Н, Аминова Х. М.",
                //2 пара:
                "Архитектура ИС", "4.13", "Ахмедова Н. М.",
                //3 пара:
                "СПиСИП", "(2п/г) 2.11", "Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",


// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Теория ИП", "3.14", "Рабаданова Р. М.",
                //4 пара:
                "СПиСИП", "3.14", "Ахмедова Н.М. ",
                //5 пара:
                "СПиСИП", "1 подгр., 2.11", "Ахмедова Н.М. ",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "АИС / ИБ и ЗИ", "ВЦ (1 п.) / 2.11 (2 п.)", "Ахмедова Н. М. / Исабекова Т. И.",
                //5 пара:
                "Web-технологии", "2.15", "Ахмедова Н. М.",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Мульт. технологии / ИСИС", "2.11 (1 п.) / 2.9 (2 п.)", "Гаджиев Т. С. / Рабаданова Р. М.",
                //4 пара:
                "ИБ и ЗИ", "3.14", "Исабекова Т. И.",
                //5 пара:
                "ИСИС (лаб.)", "1 подгр., 2.9", "Рабаданова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "МиСПИСиИТ / Web-технологии", "ВЦ (1 п.) / 2.11 (2 п.)", "Магомедова С. Р. / Ахмедова Н. М.",
                //5 пара:
                "Цифровые сети", "ВЦ", "Муталов М.С.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Архитектура ИС", "2.1", "Ахмедова Н. М.",
                //5 пара:
                "ИСИС", "3.14", "Рабаданова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Рус. и даг. лит-ра", "4.16", "Ширванова Э. Н, Аминова Х. М.",
                //2 пара:
                "Цифровые сети", "ВЦ", "Муталов М.С.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();


    }
    public void courseThreeIB(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Физкультура", "Спорткомплекс ДГУ", " ",
                //4 пара:
                "СУБД / Выч. сети", "ВЦ (1 п.) / 2.12 (2 п.)", "Шахабутдинов Я. М. / Бакмаев А. Ш. ",
                //5 пара.:
                "СУБД", "4.17", "Шахабутдинов Я. М.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Моделирование ИП (лаб)", "2 подгр., 2.9", "Исабекова Т. И.",
                //3 пара:
                "Моделирование ИП", "3.14", "Исабекова Т.И.",
                //4 пара:
                "Техническая ЗИ", "3.14", "Ахмедова З. Х.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Основы УД", "3.14", " Юсупова М. Г.",
                //4 пара:
                "ТЧМК / МИП", "2.11 (1 п.) / ВЦ (2 п.)", "Муртузалиева А. А. / Исабекова Т. И.",
                //5 пара:
                "Моделирование ИП", "1 подгр., 2.11", "Исабекова Т. И.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Техническая ЗИ (практ.)", "2.1", "Ахмедова З. Х.",
                //3 пара:
                "Методы оптимизации", "2.1", "Гаджиева Т. Ю.",
                //4 пара:
                "Методы оптимизации", "2.1", "Гаджиева Т. Ю.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Системы ИИ", "2.15", "Муртузалиева А. А.",
                //5 пара:
                "ТЧМК", "2.15", "Муртузалиева А. А.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Рус. и даг. лит-ра", "4.6", "Ширванова Э. Н, Аминова Х. М.",
                //2 пара:
                "Выч. сети", "2.1", "Бакмаев А. Ш.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Системы ИИ", "2.15", "Муртузалиева А. А.",
                //5 пара:
                "Выч. сети / СУБД", "2.12 (2 п.) / 2.9 (1 п.)", "Бакмаев А. Ш. / Шахабутдинов Я. М.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Системы ИИ", "4.4", "Муртузалиева А. А.",
                //4 пара:
                "Техническая ЗИ", "3.14", "Ахмедова З. Х.",
                //5 пара:
                "Моделирование ИП (практ.)", "3.14", "Исабекова Т. И.",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Выч. сети (практ.)", "4.4", "Бакмаев А. Ш.",
                //4 пара:
                "Основы УД", "4.4", " Юсупова М. Г.",
                //5 пара:
                "МИП / ТЧМК", "ВЦ (1 п.) / 2.11 (2 п.)", "Исабекова Т. И. / Муртузалиева А. А.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Методы оптимизации", "2.1", "Гаджиева Т. Ю.",
                //4 пара:
                "Методы оптимизации", "2.1", "Гаджиева Т. Ю.",
                //5 пара:
                "СУБД (практ.)", "3.14", "Шахабутдинов Я. М.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "ТЧМК", "4.13", "Муртузалиева А. А.",
                //5 пара:
                "Системы ИИ", "4.13", "Муртузалиева А. А.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Рус. и даг. лит-ра", "4.16", "Ширванова Э. Н, Аминова Х. М.",
                //2 пара:
                "Моделирование ИП (практ.)", "3.14", "Исабекова Т. И.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();
    }
    public void courseThreePIM(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Физкультура", "Спорткомплекс ДГУ", " ",
                //4 пара:
                "Инф. менеджмент / ИБ (лаб.)", "2.10 (1 п.) / 2.11 (2 п.)", "Билалова И. М. / Гаджиев А. М.",
                //5 пара:
                "Проектирование ИС", "2.15", "Гаирбекова П. И.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Основы библиографии и КД", "1 подгр., 2.1", " Магомедов А. М.",
                //4 пара:
                "Основы библиографии и КД", "2.1", " Магомедов А. М.",
                //5 пара:
                "Основы библиографии и КД", "2 подгр., 2.3", " Магомедов А. М.",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Проектирование ИС", "4.6 ", "Камилов М. Б.",
                //4 пара:
                "Бизнес-менеджмент", "2.1", "Муртилова К. М.",
                //5 пара:
                "Бизнес-менеджмент", "2.1", "Муртилова К. М.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Проектирование ИС (лаб.)", "1 подгр., 2.10 ", "Гасанова Н. Р.",
                //4 пара:
                "Инф. менеджмент", "2.15", "Билалова И. М.",
                //5 пара:
                "Бизнес-менеджмент", "2.15", "Муртилова К. М.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "КТвФМ", "2.3", "Магомедов А.М.",
                //5 пара:
                "КТвФМ / Инф. менеджмент", "2.3 (1 п.) / 2.10 (2 п.)", "Магомедов А.М. / Билалова И. М.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Инф. менеджмент", "2.1", "Билалова И. М.",
                //2 пара:
                "Рус. и даг. лит-ра", "4.16", "Ширванова Э. Н, Аминова Х. М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",


// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Инф. менеджмент / ПИС", "2.3 (1 п.) / 2.9 (2 п.)", "Билалова И. М. / Гасанова Н. Р.",
                //4 пара:
                "Информационная безопасность", "4.16", "Гаджиев А. М.",
                //5 пара:
                "КТвФМ (лаб.)", "2 подгр., 2.3", "Магомедов А. М.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Бизнес-менеджмент", "2.1", "Муртилова К. М.",
                //4 пара:
                "Основы библиографии и КД", "2 подгр., 2.3", " Магомедов А. М.",
                //5 пара:
                "ИБ (лаб.)", "1 подгр., 2.11", "Гаджиев А. М.",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Проектирование ИС", "4.16 ", "Камилов М. Б.",
                //4 пара:
                "Инф. менеджмент", "4.17", "Билалова И. М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Бизнес-менеджмент", "4.17", "Муртилова К. М.",
                //5 пара:
                "Бизнес-менеджмент", "4.17", "Муртилова К. М.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Инф. менеджмент", "4.17", "Билалова И. М.",
                //4 пара:
                "ОБиКД / Инф. менеджмент", "2.3 (1 п.) / 2.11 (2 п.)", "Магомедов А.М. / Билалова И. М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Информационная безопасность", "4.16", "Гаджиев А. М.",
                //2 пара:
                "Рус. и даг. лит-ра", "4.16", "Ширванова Э. Н, Аминова Х. М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();



    }
    public void courseThreePIE(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Физкультура", "Спорткомплекс ДГУ", " ",
                //4 пара:
                "РПП", "4.16", "Баммаева Г. А.",
                //5 пара:
                "РПП", "1 подгр., 2.10", "Баммаева Г. А.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Проектирование ИС / МиИМ", "2.11 (1 п.) / 2.10 (2 п.)", "Гаирбекова П. И. / Гасанова Н. Р.",
                //5 пара:
                "Проектирование ИС", "4.4", "Гаирбекова П. И. ",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Проектирование ИС", "4.6 ", "Камилов М. Б.",
                //4 пара:
                "МиИМ", "4.6", "М-гаджиев Ш. М.",
                //5 пара:
                "БИС", "2 подгр., 2.3", "Шахбанова З. И.",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "РПП (практ.)", "4.4", "Баммаева Г. А.",
                //4 пара:
                "МиИМ / РПП", "2.10 (1 п.) / 2.3 (2 п.)", "М-гаджиев Ш. М. / Баммаева Г. А.",
                //5 пара:
                "КИР (лаб.)", "4.16", "Рабаданова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "МиИМ", "4.6", "М-гаджиев Ш. М.",
                //5 пара:
                "БИС", "4.6", "Шахбанова З.И.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "Информационная безопасность", "4.13", "Гаджиев А. М.",
                //2 пара:
                "Рус. и даг. лит-ра", "4.6", "Ширванова Э. Н, Аминова Х. М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "БИС", "2 подгр., 2.11", "Шахбанова З. И.",
                //4 пара:
                "Информационная безопасность", "4.16", "Гаджиев А. М.",
                //5 пара:
                "КИР", "1 подгр., 2.10", "Рабанадова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "РПП (практ.)", "4.4", "Баммаева Г. А.",
                //4 пара:
                "РПП / ИБ", "2.3 (1 п.) / 2.10 (2 п.)", "Баммаева Г. А. / Гаджиев А. М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "РПП", "2 подгр., 2.9", "Баммаева Г. А.",
                //3 пара:
                "Проектирование ИС", "4.16 ", "Камилов М. Б.",
                //4 пара:
                "РПП (практ.)", "4.16", "Баммаева Г. А.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Информационная безопасность", "1 подгр., 2.11", "Гаджиев А. М.",
                //3 пара:
                "КИР (практ.)", "4.13", "Рабаданова Р. М.",
                //4 пара:
                "МиИМ (лаб.)", "4.4", "М-гаджиев Ш. М.",
                //5 пара:
                "КИР", "2 подгр., 2.9", "Рабаданова Р. М.",
                //6 пара:
                " ", " ", " ",

                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "БИС", "4.4", "Шахбанова З. И.",
                //5 пара:
                "БИС / Проектирование ИС", "2.10 (1 п.) / 2.11 (2 п.)", "Шахбанова З. И. / Гаирбекова П. И.",
                //6 пара:
                " ", " ", " ",

                // Суббота, 1 пара:
                "БИС", "2.10", "Шахбанова З. И.",
                //2 пара:
                "Рус. и даг. лит-ра", "4.6", "Ширванова Э. Н, Аминова Х. М.",
                //3 пара:
                "БИС", "1 подгр., 2.3", "Шахбанова З. И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();

    }
    //4 КУРС ФИИИТ
    public void courseFourISiT(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Надежность ИС", "2.15", "Ахмедова Н.М.",
                //5 пара:
                "Надежность ИС", "2.15", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Инт. робототехника", "3.14", "Муталов М.С.",
                //5 пара:
                "Инт. робототехника", "3.14", "Муталов М.С.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Геоинформационные системы", "1 подгр., 2.11", "Гаджиев А. М.",
                //3 пара:
                "Инт. робототехника", "3.14", "Муталов М.С.",
                //4 пара:
                "Геоинформационные системы", "2 подгр., 2.11", "Гаджиев А. М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Надежность ИС", "4.13", "Ахмедова Н.М.",
                //5 пара:
                "ГеоИС / НИС", "2.11 (1 п.) / 2.9 (2 п.)", "Гаджиев А. М. / Ахмедова Н. М.",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Надежность ИС", "3.14", "Ахмедова Н.М.",
                //2 пара:
                "Геоинформационные системы", "3.14", "Гаджиев А. М.",
                //3 пара:
                "Геоинформационные системы", "2 подгр., 2.9", "Гаджиев А. М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Геоинформационные системы", "4.13", "Гаджиев А. М.",
                //5 пара:
                "Инт. робототехника", "4.13", "Муталов М.С.",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Геоинформационные системы", "4.13", "Гаджиев А. М.",
                //5 пара:
                "Инт. робототехника", "4.13", "Муталов М.С.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Геоинформационные системы", "3.14", "Гаджиев А. М.",
                //4 пара:
                "Инт. робототехника", "3.14", "Муталов М.С.",
                //5 пара:
                "Надежность ИС", "1 подгр., 2.11", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Надежность ИС", "1 подгр., 2.9", "Ахмедова Н.М.",
                //4 пара:
                "Инт. робототехника", "3.14", "Муталов М.С.",
                //5 пара:
                "Надежность ИС", "2 подгр., 2.12", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Геоинформационные системы", "2.11", "Гаджиев А. М.",
                //3 пара:
                "Геоинформационные системы", "3.14", "Гаджиев А. М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();

    }
    public void courseFourIB(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                "Криптографические протоколы", "3.14", "Ахмедова Н.М.",
                //2 пара:
                "МОБ КС", "2.1", "Ахмедова Н.М.",
                //3 пара:
                "Криптографические протоколы", "1 подгр., 2.9", "Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                "Крипт. протоколы", "2 подгр., 2.9", "Ахмедова Н.М.",
                //2 пара:
                "Надежность ИС", "2.15", "Ахмедова Н.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Надежность ИС", "1 подгр., 2.11", "Ахмедова Н.М.",
                //3 пара:
                "ТОКБ", "2.15", "Нурмагомедов Ш. А.",
                //4 пара:
                "Крипт. протоколы (лаб.)", "2.15", "Ахмедова Н.М.",
                //5 пара:
                "Крипт. протоколы", "2 подгр., 2.9", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Надежность ИС", "2 подгр., ВЦ", "Ахмедова Н.М.",
                //3 пара:
                "Крипт. протоколы", "2 подгр., 2.12", "Ахмедова Н.М.",
                //4 пара:
                "Крипт. протоколы", "4.17", "Ахмедова Н.М.",
                //5 пара:
                "Крипт. протоколы", "1 подгр., 2.11", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                "ТОКБ", "2.15", "Нурмагомедов Ш. А.",
                //3 пара:
                "Надежность ИС", "3.14", "Ахмедова Н.М.",
                //4 пара:
                "Надежность ИС", "2 подгр., 2.12", "Ахмедова Н.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                "Крипт. протоколы", "1 подгр., 2.11", "Ахмедова Н.М.",
                //2 пара:
                "МОБ КС", "2.15", "Ахмедова Н.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Надежность ИС", "2.15", "Ахмедова Н.М.",
                //3 пара:
                "ТОКБ", "2.15", "Нурмагомедов Ш.А.",
                //4 пара:
                "Надежность ИС", "1 подгр., 2.11", "Ахмедова Н.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Надежность ИС", "2.15", "Ахмедова Н.М.",
                //3 пара:
                "МОБ КС", "2.15", "Ахмедова Н.М.",
                //4 пара:
                "Крипт. протоколы (лаб.)", "2.15", "Ахмедова Н.М.",
                //5 пара:
                "Крипт. протоколы", "2 подгр., 2.12", "Ахмедова Н.М.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                "Крипт. протоколы", "2 подгр., ВЦ", "Ахмедова Н.М.",
                //2 пара:
                "МОБ КС", "3.14", "Ахмедова Н.М.",
                //3 пара:
                "Крипт. протоколы", "1 подгр., 2.12", "Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                "ТОКБ", "3.14", "Нурмагомедов Ш.А.",
                //2 пара:
                "Надежность ИС", "3.14", "Ахмедова Н.М.",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Надежность ИС", "1 подгр., 2.11", "Ахмедова Н.М.",
                //2 пара:
                "Крипт. протоколы (лаб.)", "3.14", "Ахмедова Н.М.",
                //3 пара:
                "Надежность ИС", "2 подгр., 2.11", "Ахмедова Н.М.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };

// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", false).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();

    }
    public void courseFourPIM(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "КМБП (лаб.)", "2.3", "Магомедов А.М.",
                //4 пара:
                "КМБП (лаб.)", "2.3", "Магомедов А.М.",
                //5 пара:
                "КМБП (лаб.)", "2.1", "Магомедов А.М.",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "ИМвИТ (лаб.)", "2.3", "Муртилова К.М.",
                //5 пара:
                "ИМвИТ", "2.1", "Муртилова К.М.",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "ИМвИТ", "4.8", "Муртилова К.М.",
                //4 пара:
                "ЭСвЭиБ", "4.17", "Билалова Е.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "ЭСвЭиБ (лаб.)", "2.3", "Билалова Е.М.",
                //4 пара:
                "ИМвИТ", "4.4", "Муртилова К.М.",
                //5 пара:
                "ЭСвЭиБ", "2.1", "Билалова Е.М.",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "КМБП (лаб.)", "2.1", "Магомедов А.М.",
                //4 пара:
                "Управление проектами", "2.1", "Исаибова Д.И.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Управление проектами", "4.4", "Исаибова Д.И.",
                //3 пара:
                "Управление проектами", "4.4", "Исаибова Д.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "КМБП (практ.)", "2.15", "Магомедов А.М.",
                //4 пара:
                "КМБП (лаб.)", "2.3", "Магомедов А.М.",
                //5 пара:
                "ЭСвЭиБ", "2.1", "Билалова Е.М.",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "КМБП (лаб.)", "2.3", "Магомедов А.М.",
                //4 пара:
                "ИМвИТ", "4.4", "Муртилова К.М.",
                //5 пара:
                "КМБП (лаб.)", "2.3", "Магомедов А.М.",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "ИМвИТ (лаб.)", "2.3", "Муртилова К.М.",
                //5 пара:
                "ИМвИТ", "2.15", "Муртилова К.М.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "ИМвИТ (лаб.)", "2.10", "Муртилова К.М.",
                //4 пара:
                "ЭСвЭиБ", "2.15", "Билалова Е.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                "Управление проектами", "2.15", "Исаибова Д.И.",
                //5 пара:
                "ЭСвЭиБ (лаб.)", "2.9", "Билалова Е.М.",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Управление проектами (лаб.)", "2.10", "Исаибова Д.И.",
                //3 пара:
                "Управление проектами", "2.1", "Исаибова Д.И.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

        };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", true).commit();

        setTextOnEdit();
    }
    public void courseFourPIE(){
        strMas = new String[]{
                // 1 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Разработка АРМ", "1 подгр., 2.11", "Гасанова Н.Р.",
                //3 пара:
                "Системная АИС", "4.16", "Шарипова Н.Х.",
                //4 пара:
                "Разработка АРМ", "1 подгр., 2.9", "Гасанова Н.Р.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Разработка АРМ", "4.6", "Гасанова Н.Р.",
                //3 пара:
                "КМвЭ", "4.16", "Касимова Т.М.",
                //4 пара:
                "ПМиССИвЭ", "4.16", "Адамадзиев К.Р.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Разработка АРМ", "4.6", "Гасанова Н.Р.",
                //3 пара:
                "КМвЭ", "2.1", "Касимова Т.М.",
                //4 пара:
                "КМвЭ", "2 подгр., 2.3", "Касимова Т.М.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                "Системная АИС", "4.16", "Шарипова Н.Х.",
                //4 пара:
                "ПМиССИвЭ", "4.16", "Адамадзиев К.Р.",
                //5 пара:
                "Системная АИС", "2 подгр., 2.3", "Шарипова Н.Х.",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                "КМвЭ", "1 подгр., 2.10", "Гасанова Н.Р.",
                //3 пара:
                "Разработка АРМ", "4.13", "Гасанова Н.Р.",
                //4 пара:
                "ПМиССИвЭ", "4.16", "Адамадзиев К.Р.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                "Системная АИС", "1 подгр., 2.3", "Шарипова Н.Х.",
                //2 пара:
                "Системная АИС", "4.17", "Шарипова Н.Х.",
                //3 пара:
                "Системная АИС", "2 подгр., 2.3", "Шарипова Н.Х.",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",

// 2 неделя
                // Понедельник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "КМвЭ", "1 подгр., 2.11", "Гасанова Н.Р.",
                //3 пара:
                "Системная АИС", "4.16", "Шарипова Н.Х.",
                //4 пара:
                "Разработка АРМ", "2.1", "Гасанова Н.Р.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Вторник, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Разработка АРМ / САИС", "2.10 (1 п.) / 2.3 (2 п.)", "Гасанова Н.Р. / Шарипова Н.Х.",
                //3 пара:
                "КМвЭ", "4.16", "Гасанова Н.Р.",
                //4 пара:
                "ПМиССИвЭ", "4.16", "Адамадзиев К.Р.",
                //5 пара:
                "Системная АИС", "1 подгр., 2.10", "Шарипова Н.Х.",
                //6 пара:
                " ", " ", " ",
                // Среда, 1 пара:
                " ", " ", " ",
                //2 пара:
                "КМвЭ", "2 подгр., 2.10", "Гасанова Н.Р.",
                //3 пара:
                "КМвЭ", "2 подгр., 2.10", "Касимова Т.М.",
                //4 пара:
                "Системная АИС", "2.1", "Шарипова Н.Х.",
                //5 пара:
                "Системная АИС", "1 подгр., 2.10", "Шарипова Н.Х.",
                //6 пара:
                " ", " ", " ",
                // Четверг, 1 пара:
                " ", " ", " ",
                //2 пара:
                "Системная АИС", "4.16", "Шарипова Н.Х.",
                //3 пара:
                "Разработка АРМ", "4.16", "Гасанова Н.Р.",
                //4 пара:
                "ПМиССИвЭ", "4.16", "Адамадзиев К.Р.",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Пятница, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
                // Суббота, 1 пара:
                " ", " ", " ",
                //2 пара:
                " ", " ", " ",
                //3 пара:
                " ", " ", " ",
                //4 пара:
                " ", " ", " ",
                //5 пара:
                " ", " ", " ",
                //6 пара:
                " ", " ", " ",
        };
// 1 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek1", true).commit();

// 2 неделя
        prefs.edit().putBoolean("scheduleInSundayWeek2", false).commit();

        setTextOnEdit();

    }
}
