package com.example.pencil.xiaobao.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.example.pencil.xiaobao.database.converter.DoubanTypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Entity(tableName = "douban_moment_content")
@TypeConverters(DoubanTypeConverters.class)
public class DoubanMomentContent {


  /**
   * display_style : 10002 short_url : https://dou.bz/4maMMS abstract :
   * 水浒群雄的武功排行比起三国群英来要复杂许多，首先是出场人物众多，尤其是招安之后，高手走马灯般上阵，令人眼花缭乱…… app_css : 7 like_count : 140 thumbs :
   * [{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t126366.jpg","width":306,"height":432},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t126366.jpg","width":306,"height":432},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t126366.jpg","width":306,"height":432},"id":126366}]
   * created_time : 2017-07-21 23:34:09 id : 179315 is_editor_choice : false original_url :
   * https://www.douban.com/note/629759652/ content : <div id="header"> <p id="title">水浒群雄武功排行榜</p>
   * <p class="info">
   *
   * <span id="collumn">| 闲翻书 |</span>
   *
   *
   * <span id="author"> 来自：<a href="https://www.douban.com/people/luhua/">芦哲峰</a> 的日记 </span>
   *
   * </p> </div>
   *
   * <div id="content"><p><a href="https://book.douban.com/subject/2033597/">水浒</a>群雄的武功排行比起三国群英来要复杂许多，首先是出场人物众多，尤其是招安之后，高手走马灯般上阵，令人眼花缭乱；其次是功夫种类繁杂，不光只有马上对阵一种，还出现了武林侠客的打法——拳击格斗，以及各种怪力乱神的妖法、暗器等旁门左道。因此，水浒群雄的武功高下比较起来，颇有些难度。</p><p>为了便于比较，还是先从梁山好汉说起。法术、暗器和水下功夫暂且不表，单以马上马下的武功论，梁山一百单八将大致有一个现成的排行：</p><p>马上，当以玉麒麟卢俊义为首，此人身高九尺，惯使一条棍棒，天下无对，曾头市一战，力擒史文恭（史文恭只用二十回合就打败秦明）；招安之后，力敌耶律四将不怯（四将武功都不弱，曾分别对阵关胜、呼延灼、徐宁、索超，虽回数不多，但未分胜负），并诛杀一人，击退三人；百战孙安；活捉卞祥；枪挑厉天闰，除与王庆手下之金剑先生李助交手时，处于下风以外，未曾一败，可谓武功盖世，是整部水浒中的顶级高手之一，功夫远胜梁山五虎将。</p><p>接下来是五虎将——大刀关胜、豹子头林冲、双鞭呼延灼、双枪将董平、霹雳火秦明。其中关胜、林冲较后三人，技高一筹，招安之后，每遇劲敌，非此二人出战不可，对战敌将无数，未有败绩；然后是呼延灼和董平，呼延灼防守能力极强，基本上没有败绩。董平进攻能力似较呼延灼略高一点，但防守能力不及，多次处于险境之中；五虎将里武功最末的是秦明，与敌交手，胜绩不少，但败绩更多，最差战绩是二十回合败给史文恭，二十回合被栾廷玉所擒，其真实功力可能只与八骠骑之花荣、徐宁、杨志相仿佛。</p><p>梁山五虎将之后，便是八骠骑——小李广花荣、青面兽杨志、金枪手徐宁、九纹龙史进、急先锋索超、没羽箭张清、美髯公朱仝和没遮拦穆弘，还有两位与八骠骑武功相当的，即扑天雕李应和病尉迟孙立。这十个人武功大致在一个档次，花荣、杨志、徐宁、史进、孙立略高半筹；张清暗器无敌，但枪法一般；穆弘基本上没什么突出表现，应该算是这一组里武功最弱的。</p><p>马下，当以鲁智深和武松为首，接下来依次是赤发鬼刘唐、病关索杨雄、浪子燕青、拼命三郎石秀、插翅虎雷横和黑旋风李逵。水浒传里凡遇到马下与马上对阵时，马下都很吃亏，只有鲁智深和武松具有正面抗衡马军将领的能力，二人武功大致与五虎将相当；刘唐、杨雄、燕青与八骠骑相若；石秀、雷横、李逵较八骠骑稍弱。</p><p>鲁智深其人面圆耳大，鼻直口方，腮边貉腮胡须，身长八尺，腰润十围，力大无穷，手使六十二斤重水磨禅杖，上山之前曾拳打镇关西、大闹五台山、大闹桃花村、火烧瓦罐寺、倒拔垂杨柳、大闹野猪林、单打二龙山；招安之后，活捉马灵，大战邓元觉，生擒方腊，屡立奇功。三山聚义打青州时，曾在马上与呼延灼大战五十回合不分胜负，使得呼延灼心里暗赞这和尚功夫了得，马上对战非鲁智深所长，却能与呼延灼打成平手，若在马下，胜呼延灼不在话下；</p><p>武松其人身躯魁梧，壮健非常，力大无比，曾于景阳冈徒手毙虎，还曾轻易举起天王堂前四五百斤石墩，掷高一丈后轻松接住；斗杀西门庆，醉打蒋门神，用了玉环步、鸳鸯脚等武林绝学；大战飞天蜈蚣王道人，以双刀胜双剑。招安之后，还曾三次只用一招便斩了马上之将，可见，武松是真正的武林高手，可称梁山步战第一人；</p><p>以上二十四位，便是梁山好汉里武功最高的二十四人，按武功高低大体排行应为：卢俊义、关胜、林冲、鲁智深、武松、呼延灼、董平、秦明、花荣、杨志、徐宁、孙立、史进、索超、李应、朱仝、张清、刘唐、杨雄、燕青、石秀、穆弘、雷横、李逵。其中，卢俊义是顶级高手；五虎将和鲁智深、武松是超一流高手；剩下的十六人，可归为一流高手行列。</p><p>梁山有一百单八将之众，却也未能囊括天下英雄。正所谓天外有天，人外有人，梁山之外，依旧是高手如云。接下来，我们以秦明为界，看看整部水浒中，武功胜过秦明的超一流高手，都有哪些。按照出场先后，逐个加以评说：</p><p>A：七十回之前，梁山之外的高手共有三位，分别是：王进、栾廷玉和史文恭：</p><p>王进：原为东京八十万禁军教头，因得罪高俅，带母私走延安府，路过史家村时，一合即打败史进，后做了史进的师傅，史进跟其学了半年功夫，便十八般武艺样样精通，名列梁山八骠骑之一。必有名师，方出高徒，王进虽然未与水浒中其他高手交过手，但据此来看，此人武功绝不下于林冲；</p><p>栾廷玉：祝家庄的武术教师，善使铁棒，号称“铁棒奕廷玉”，江湖闻名。与秦明战，只一二十合便将秦明用绊马索拿了。如此武功，与秦明同列五虎将的关胜、林冲，当然无法做到；</p><p>史文恭：曾头市的武术教师，此人骑照夜玉狮子马，手使一支方天画戟，武功超群，枪法出众，勇猛无比。与秦明战，约二十余合，秦明败阵，走时被史文恭一枪刺在腿股上，吕方、郭盛、马麟、邓飞四将齐出死命来救秦明，却也抵挡不住史文恭。后被卢俊义活捉。</p><p>B：十节度使征讨梁山时，武功出色的有四位，依次是：王焕、韩存保、项元镇和张开：</p><p>王焕：河南河北节度使，与林冲大战七、八十合，未分胜负；</p><p>韩存保：云中门节度使，与呼延灼从马上打到马下，旗鼓相当，难分高下；</p><p>项元镇：琅琊彭城节度使，与董平战约十合左右，瞅准时机，箭射董平右臂，致使董平弃枪逃归本阵。据此看，其武功射功应比花荣略胜之；</p><p>张开：中山安平节度使，战张清，马上这条枪，神出鬼没，张清只有招架之功（张清飞石厉害，枪法却只一般），没有还手之力，拖了枪，便走入马军队里躲闪。张开枪马到处，杀得五六十马军，四分五落。此人武功应与秦明相当。</p><p>C：招安之后，梁山奉诏征讨大辽，遇到辽国众多高手，其中最厉害的三位是阿里奇、兀颜光和琼妖纳延：</p><p>阿里奇：辽国檀州守将，手拈梨花点钢枪，坐骑银色拳花马，有万夫不当之勇。徐宁与之战，三十余合即败走。能在三十回合杀败徐宁，此人武功在五虎将之上，略低于史文恭和栾廷玉。后被张清用石子打中左眼落马，被擒杀；</p><p>兀颜光：辽国第一上将，十八般武艺，无有不通，兵书战策尽皆闲熟。上阵时，仗条浑铁点钢枪杀到浓处，不时擎出腰间铁筒，使得铮铮有声，端的是万夫不当之勇。后来在混天象阵里，被关胜、花荣和张清联手斩杀，关胜武功，梁山第二，花荣、张清是梁山暗器最厉害的两位，三人联手方能诛杀兀颜光，可见此人武功之高。</p><p>琼妖纳延：辽国兀颜统军座下先锋，三十回合杀退史进。</p><p>D：田虎手下，高手有二，孙安、卞祥：</p><p>孙安：田虎手下殿帅，身长九尺，腰大八围，颇知韬略，臂力过人，学得一身出色的好武艺，惯使两口镔铁剑。与秦明斗五六十回合不分胜负，又与卢俊义斗五十余合，忽马失前踢，孙安颠下马，卢俊义令其换马再战。五十余合后，卢俊义佯败，孙安被绊马锁绊倒，活捉归顺后，助卢俊义斩杀杜壆；</p><p>卞祥：田虎手下太师，庄稼出身，两条臂膊水牛般气力，武艺精熟，金冠银甲，身长九尺，跨匹冲波战马，提开山大斧。史进曾与卞祥战三十余合，花荣拍马提枪助战，二打一又战三十余合无胜败，各自收兵。后被卢俊义活捉。后宋江亲释其缚，以礼相待，遂感激归降。攻打王庆时，卞祥见山士奇斗不过酆泰，拈枪拍马助战，大喝一声，一枪刺中酆泰心窝，死于马下。</p><p>E：王庆手下，高手有四位，袁朗、杜壆、酆泰、李助：</p><p>袁朗：王庆手下将领，骑一匹卷毛乌骓，两个水磨炼钢挝，左手十五斤，右手十六斤，与秦明战，一百五十余合不分胜负；</p><p>杜壆：王庆手下将领，身高八尺又八，威风凛凛，自幼练得好武艺，与卢俊义交战，五十余合不分胜负，手中那条丈八蛇矛枪神出鬼没。孙安见卢俊义不能取胜，舞剑拍马助战，杜壆措手不及，被一剑砍断右臂，翻身落马，卢俊义再一枪结果了性命；</p><p>酆泰：王庆手下将领，身材魁梧，膂力过人，能征贯战。与山士奇战，斗到十合以上，卞祥见山士奇斗不过酆泰，拈枪拍马助战，被酆泰大喝一声，只一简，把山士奇打下马来，再一简，结果了性命，山士奇原是田虎手下，曾与林冲斗五十回合不分胜负，据此情形看，山士奇武功应与杨志相若，却被酆泰十几回合斩杀，由此看，酆泰武功只会在林冲之上，不会在林冲之下；</p><p>李助：王庆军师，号金剑先生，剑术无敌，一把剑舞将起来，如掣电一般，此人是全书中惟一一位单打独斗让卢俊义抵挡不住的人物，后被公孙胜用法术制服。</p><p>F：方腊手下，高手有六位：邓元觉、石宝、司行方、厉天闰、方杰、王寅：</p><p>邓元觉：方腊手下宝光如来国师，使浑铁禅杖，重五十余斤。鲁智深与邓元觉斗五十余合不分胜负，武松见鲁智深战宝光不下，恐有疏失，心中焦躁，飞出阵来助战，邓望城里便走。后与秦明交战五六合，见秦明输了，径奔来捉宋江，被花荣一箭射落马下，被众军杀死；</p><p>石宝：方腊手下南离大将军元帅，福州人氏，惯使一个流星锤，百发百中，又能使一口宝刀，名为“劈风刀”，可以裁铜截铁，遮莫三层铠甲，如劈风一般过去。曾锤打八骠骑之一骁将急先锋索超；战吕方、郭盛两枝戟，没半分漏泄，直至又加上朱仝一条枪，才败走。遇关胜，不敢恋战，关胜也不敢轻取；</p><p>司行方：方腊手下护国大将军，三十回合砍杀雷横；</p><p>厉天闰：方腊手下镇国大将军，破单手董平与张清的联手，刺死张清；</p><p>方杰：方腊侄儿，惯使一枝方天通戟，有万夫不当之勇。与秦明战三十余合不分胜负，杜微背后飞刀，秦明闪时被方杰杀死。关胜与方杰战十数合，花荣又上，方杰力敌二将全无惧色，又战数合，难见输赢，却只没遮拦躲避，李应、朱仝再上，方杰才退，却不防被附马柯引（柴进）一枪戳着，燕青一刀结果其性命；</p><p>王寅：方腊手下兵部尚书，此人惯使一条钢枪，坐下有一骑好马，名唤“转山飞”，登山渡水，如行平地。李云、石勇数合死于王寅枪下。孙立、黄信、邹渊、邹润四将与王寅撕杀，那王寅奋勇力敌四将，并无惧怯。不想又撞出林冲赶到，一并围战，被乱戮而杀。</p><p>至此，我们可以得出整部水浒中超一流高手前三十名的排行如下：</p><p>1、李助：剑法高明，一对一，让卢俊义抵挡不住；</p><p>2、卢俊义：擒史文恭；胜耶律四将；胜孙安；擒卞祥；枪挑厉天闰；</p><p>3、方杰：刺死秦明；力敌关胜、花荣联手而不惧，李应、朱仝再上，方杰才退；</p><p>4、兀颜光：辽国第一猛将，梁山武功第二的关胜，加上暗器最厉害的花荣、张清，方才将其斩杀；</p><p>5、王寅：力敌孙立、黄信、邹渊、邹润四将而不败，加上林冲才将其刺死；</p><p>6、史文恭：射杀晁盖；二十回合胜秦明；吕方、郭盛、马麟、邓飞四将齐出，亦敌不住；</p><p>7、卞祥：力敌史进、花荣联手，三十回合而不败；斩杀功夫在林冲之上的酆泰；</p><p>8、栾廷玉：二十回合擒秦明；</p><p>9、杜壆：与卢俊义对战五十回合而不败；</p><p>10、王进：八十万禁军教头，半年之内教会史进十八般武艺；</p><p>11、酆泰：十几回合即斩杀与林冲对阵五十回合不分胜负的山士奇；</p><p>12、关胜：梁山五虎将之首，十回合杀得索超斧怯；征方腊时，斩将颇多；</p><p>13、石宝：诛杀梁山好汉多名：马麟、燕顺、索超、邓飞、鲍旭等都命丧其手；与关胜棋逢对手；</p><p>14、阿里奇：三十回合击败徐宁；</p><p>15、林冲：梁山五虎将排名第二，对敌无数，未曾一败，其实际功夫应与关胜伯仲之间；</p><p>16、鲁智深：倒拔垂杨柳，力逾千钧。马上对阵呼延灼五十回合不分胜负，马下与邓元觉打成平手；</p><p>17、邓元觉：与鲁智深对战不分胜负；</p><p>18、武松：徒手毙虎，斗杀西门庆，醉打蒋门神，刀砍飞天蜈蚣，还曾三次，马下对马上一招斩将；</p><p>19、王焕：与林冲对战七十回合未分胜负；</p><p>20、司行方：三十回合斩杀雷横；</p><p>21、琼妖纳延：与史进战，处于上风，三十回合吓退史进；</p><p>22、呼延灼：与林冲、鲁智深、孙立、杨志对战，均不分胜负，其防守能力胜于进攻能力，征辽时，曾活捉兀颜延寿；</p><p>23、韩存保：与呼延灼对战，打成平手；</p><p>24、厉天闰：单手董平与张清联手，不敌厉天闰；</p><p>25、孙安：与秦明斗五六十合不分胜负，又与卢俊义斗五十合，后被卢俊义所擒，功夫当在秦明之上，卢俊义之下；</p><p>26、项元镇：对阵董平十回合后，箭射董平右臂；</p><p>27、张开：杀得张清落荒而逃；</p><p>28、董平：与徐宁交战五十回合，不分胜负，但处在上风；征辽时枪挑辽国大将耶律国珍；</p><p>29、秦明：勇猛无比，性如烈火，单挑次数在梁山数一数二，但防守能力较差，曾先后败于顶尖高手栾廷玉、史文恭和方杰之手；论武功，当为梁山五虎将之末；</p><p>30、袁朗：对阵秦明一百五十回合不分胜负；</p><p>三国篇请戳
   * → <a href="https://www.douban.com/note/629492844/">三国群英武功排行榜</a></p></div>
   *
   * <div id="footer">
   *
   * <div class="url_box"> <a id="original_url" href="https://www.douban.com/note/629759652/">来源：水浒群雄武功排行榜</a>
   * </div>
   *
   * </div>
   *
   *
   * share_pic_url : https://moment.douban.com/share_pic/post/179315.jpg type : 1001 is_liked :
   * false photos : [] published_time : 2017-08-14 04:00:00 url : https://moment.douban.com/post/179315/?douban_rec=1
   * author : {"is_followed":false,"uid":"luhua","url":"https://www.douban.com/people/luhua/","avatar":"https://img1.doubanio.com/icon/u1329080-9.jpg","name":"芦哲峰","is_special_user":false,"n_posts":0,"alt":"灵魂深处有个鬼，这鬼跟你有一腿","large_avatar":"https://img1.doubanio.com/icon/up1329080-9.jpg","id":"1329080","is_auth_author":false}
   * column : 闲翻书 comments_count : 7 title : 水浒群雄武功排行榜
   */


  @ColumnInfo(name = "display_style")
  @Expose
  @SerializedName("display_style")
  private int displayStyle;

  @ColumnInfo(name = "display_style")
  @Expose
  @SerializedName("short_url")
  private String shortUrl;

  @ColumnInfo(name = "abstract")
  @Expose
  @SerializedName("abstract")
  private String abs;


  @ColumnInfo(name = "app_css")
  @Expose
  @SerializedName("app_css")
  private int appCss;

  @ColumnInfo(name = "like_count")
  @Expose
  @SerializedName("like_count")
  private int likeCount;

  @ColumnInfo(name = "thumbs")
  @Expose
  @SerializedName("thumbs")
  private List<DoubanMomentNewsThumbs> thumbs;


  @ColumnInfo(name = "created_time")
  @Expose
  @SerializedName("created_time")
  private String createdTime;


  @ColumnInfo(name = "id")
  @PrimaryKey
  @Expose
  @SerializedName("id")
  private int id;

  @ColumnInfo(name = "is_editor_choice")
  @Expose
  @SerializedName("is_editor_choice")
  private boolean isEditorChoice;

  @ColumnInfo(name = "original_url")
  @Expose
  @SerializedName("original_url")
  private String originalUrl;

  @ColumnInfo(name = "content")
  @Expose
  @SerializedName("content")
  private String content;

  @ColumnInfo(name = "share_pic_url")
  @Expose
  @SerializedName("share_pic_url")
  private String sharePicUrl;

  @ColumnInfo(name = "type")
  @Expose
  @SerializedName("type")
  private String type;

  @ColumnInfo(name = "is_liked")
  @Expose
  @SerializedName("is_liked")
  private boolean isLiked;

  @ColumnInfo(name = "photos")
  @Expose
  @SerializedName("photos")
  private List<DoubanMomentNews> photos;

  @ColumnInfo(name = "published_time")
  @Expose
  @SerializedName("published_time")
  private String publishedTime;

  @ColumnInfo(name = "url")
  @Expose
  @SerializedName("url")
  private String url;

  @ColumnInfo(name = "column")
  @Expose
  @SerializedName("column")
  private String column;

  @ColumnInfo(name = "comments_count")
  @Expose
  @SerializedName("comments_count")
  private int commentsCount;

  @ColumnInfo(name = "title")
  @Expose
  @SerializedName("title")
  private String title;

  public int getDisplayStyle() {
    return displayStyle;
  }

  public void setDisplayStyle(int displayStyle) {
    this.displayStyle = displayStyle;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public String getAbs() {
    return abs;
  }

  public void setAbs(String abs) {
    this.abs = abs;
  }

  public int getAppCss() {
    return appCss;
  }

  public void setAppCss(int appCss) {
    this.appCss = appCss;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public List<DoubanMomentNewsThumbs> getThumbs() {
    return thumbs;
  }

  public void setThumbs(List<DoubanMomentNewsThumbs> thumbs) {
    this.thumbs = thumbs;
  }

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isEditorChoice() {
    return isEditorChoice;
  }

  public void setEditorChoice(boolean editorChoice) {
    isEditorChoice = editorChoice;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSharePicUrl() {
    return sharePicUrl;
  }

  public void setSharePicUrl(String sharePicUrl) {
    this.sharePicUrl = sharePicUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isLiked() {
    return isLiked;
  }

  public void setLiked(boolean liked) {
    isLiked = liked;
  }

  public List<DoubanMomentNews> getPhotos() {
    return photos;
  }

  public void setPhotos(List<DoubanMomentNews> photos) {
    this.photos = photos;
  }

  public String getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(String publishedTime) {
    this.publishedTime = publishedTime;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public int getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(int commentsCount) {
    this.commentsCount = commentsCount;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
