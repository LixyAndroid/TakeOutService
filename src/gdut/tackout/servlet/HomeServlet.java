package gdut.tackout.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdut.tackout.bean.Category;
import gdut.tackout.bean.HomeInfo;
import gdut.tackout.bean.Promotion;
import gdut.tackout.bean.Response;
import gdut.tackout.bean.Seller;
import gdut.tackout.utils.CommonUtil;
import net.sf.json.JSONObject;


public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    String[] names = new String[]{"麦当劳", "李先生牛肉面", "长青小吃", "麻辣村香锅", "麦当劳", "川湘渝味", "秦家面馆", "炸鸡啤酒", "辣亦有道", "麻辣风暴",
            "零食赞", "水果",};

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置data部分数据
        // 促销信息
        ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
        for (int id = 1; id < 4; id++) {
            Promotion promotion = new Promotion();
            promotion.setId(id);
            // http://localhost:8080/TakeoutService/home/
            //promotion.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/promotion/" + id + ".jpg");
            switch (id) {
                case 1:
                    promotion.setPic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557726048013&di=9fa4678958916319b034b78aa7895929&imgtype=0&src=http%3A%2F%2Fbpic.ooopic.com%2F15%2F93%2F58%2F15935833-baf697bbe746ef3f049060525267f7e6-2.jpg");
                    break;

                case 2:
                    promotion.setPic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557726203019&di=7301f0fa1f4e644eb7a008aacdb53d7d&imgtype=0&src=http%3A%2F%2Fbpic.wotucdn.com%2F15%2F93%2F58%2F15935863-7364c92a4a2c72212a35fc6177943111-3.jpg");
                    break;

                case 3:
                    promotion.setPic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557726239468&di=eaa3f78acf142eed48301fb42a30024d&imgtype=0&src=http%3A%2F%2Fwww.3987.com%2Fshouji%2Fuploadfile%2F2015%2F0209%2F20150209054525422.jpg");
                    break;

            }

            promotion.setInfo("促销信息" + id);
            promotionList.add(promotion);
        }

        // 分类信息
        ArrayList<Category> categorieList = new ArrayList<Category>();
        for (int id = 1; id < 9; id++) {
            Category category = new Category();
            category.setId(id);
            //category.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + id + ".png");

            switch (id) {
                case 1:
                    category.setPic("https://graph.baidu.com/resource/10683458ad11ef3c7af4301557716634.jpg");
                    break;
                case 2:
                    category.setPic("https://graph.baidu.com/resource/106e92bba3b1f102e496701557723016.jpg");
                    break;
                case 3:
                    category.setPic("https://graph.baidu.com/resource/106c2cc917dbe1bf5366301557723057.jpg");
                    break;
                case 4:
                    category.setPic("https://graph.baidu.com/resource/10692f6d30bd28e4c8c2d01557723087.jpg");
                    break;
                case 5:
                    category.setPic("https://graph.baidu.com/resource/106cac2b5c02121ad5e5101557723139.jpg");
                    break;
                case 6:
                    category.setPic("https://graph.baidu.com/resource/1068e635e55baf427649801557723183.jpg");
                    break;
                case 7:
                    category.setPic("https://graph.baidu.com/resource/106937e4a8958999c6adf01557723223.jpg");
                    break;
                case 8:
                    category.setPic("https://graph.baidu.com/resource/1063f4a63da06c2492cb501557723295.jpg");
                    break;
            }

            category.setName(names[id]);
            categorieList.add(category);
        }

        // nearbySellerList
        ArrayList<Seller> nearbySellerList = new ArrayList<Seller>();

        for (int i = 1; i < 11; i++) {
            Seller seller = new Seller();
            seller.setId(i);
            seller.setName("第" + i + "家分店");
            seller.setSendPrice("10");
            seller.setDeliveryFee("2");
            seller.setScore("5");
            seller.setDistance("200米/31分钟");
            seller.setSale("月售66份");
            //seller.setIcon(ConstantValue.HOST + "/TakeoutService/" + "imgs/seller/" + i%5 + ".jpg");
            switch (i) {

                case 1:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576040&di=a963e842a6801f0584c718d257e5bd52&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180712%2Fea2baf702dcd4d4d943fac5c9755ccf8.jpeg");
                    break;
                case 2:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576039&di=aaeaa7e1938c065d9add678bd0475518&imgtype=0&src=http%3A%2F%2Fcmsfile02.chinaso.com%2Fgroup1%2FM00%2F10%2FCA%2FCgqg11R_sEOACIuNAACMllM3NDQ286.png");
                    break;
                case 3:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576040&di=19133fc4031bd8c98028084259a1f9d5&imgtype=0&src=http%3A%2F%2Fwww.xaecong.com%2Fuploadfile%2F2017-10%2F20171011151034322.jpg");
                    break;
                case 4:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576040&di=b6567c5f8efaa18a83f99f07671f98e7&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01feba5a3fc490a801206ed34cd68d.jpg%401280w_1l_2o_100sh.jpg");
                    break;
                case 5:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576039&di=7734c8fcf32bf28bacb27141ee4a3403&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0140965ad1f961a80121386786e86e.jpg%401280w_1l_2o_100sh.jpg");
                    break;
                case 6:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576039&di=dca7c95ccaad4328e31b29ad08e9c028&imgtype=0&src=http%3A%2F%2Fimg.aso.aizhan.com%2Ficon%2F66%2F05%2F15%2F660515e1608687b80a96808e436fcddc.jpg");
                    break;
                case 7:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576039&di=aaeaa7e1938c065d9add678bd0475518&imgtype=0&src=http%3A%2F%2Fcmsfile02.chinaso.com%2Fgroup1%2FM00%2F10%2FCA%2FCgqg11R_sEOACIuNAACMllM3NDQ286.png");
                    break;
                case 8:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734644858&di=2cfa93739e290795e27896642ca06ec6&imgtype=0&src=http%3A%2F%2Fwww.yishunwujin.com%2Flogos%2F2014%2F10%2F02%2F2014100201485035355534.jpg");
                    break;
                case 9:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576038&di=a96a0ff7c25e4eca5b3c06625426192f&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fnuomi%2Fpic%2Fitem%2F83025aafa40f4bfbf2f64a450b4f78f0f73618f8.jpg");
                    break;
				case 10:
					seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734533454&di=f8f81badf2502ebd6f74364de8ab9c1c&imgtype=0&src=http%3A%2F%2Fp1.so.qhimgs1.com%2Ft01384b03e2ca340e9d.gif");
					break;
            }

            nearbySellerList.add(seller);
        }

        // ortherSellerList
        ArrayList<Seller> ortherSellerList = new ArrayList<Seller>();

        for (int i = 1; i < 26; i++) {
            Seller seller = new Seller();
            seller.setId(i);
            seller.setName("其他第" + i + "家分店");
            seller.setSendPrice("30");
            seller.setDeliveryFee("6");
            seller.setScore("4");
            seller.setDistance("896米/45分钟");
            seller.setSale("月售12份");
            //	seller.setIcon(ConstantValue.HOST + "/TakeoutService/" + "imgs/seller/" + i%5 + ".jpg");
            switch (i) {

                case 1:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576037&di=c3a6f2507da9e9914617bcc6e84b5983&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b4365ccea58aa8012141686901d4.jpg%401280w_1l_2o_100sh.jpg");
                    break;
                case 2:
                    seller.setIcon("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=309114890,2436457481&fm=26&gp=0.jpg");
                    break;
                case 3:
                    seller.setIcon("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1674651457,4018547800&fm=26&gp=0.jpg");
                    break;
                case 4:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576036&di=9bb4ff3856f14c39a2a11f0dd945edb7&imgtype=0&src=http%3A%2F%2Fpro5478ae.pic5.websiteonline.cn%2Fupload%2Ffxrj.jpg");
                    break;
                case 5:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734038019&di=a399c3829a3f0db8dbee30b2eb08de28&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fnuomi%2Fpic%2Fitem%2Fe1fe9925bc315c60121a30ee8ab1cb1349547727.jpg");
                    break;
                case 6:
                    seller.setIcon("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2404782513,420631249&fm=26&gp=0.jpg");
                    break;
                case 7:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734038017&di=4d0cafcd3bb6189ee927b3ee2aa4e5b8&imgtype=0&src=http%3A%2F%2Fp5.zbjimg.com%2Ftask%2F2011-10%2F13%2F1140264%2Fhuge4e95d00523663.jpg");
                    break;
                case 8:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734105978&di=9163f8f5a374bcf2e23520c00cf21d80&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fnuomi%2Fpic%2Fitem%2F3bf33a87e950352a7b9f8cbc5543fbf2b3118b8c.jpg");
                    break;
                case 9:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734105977&di=473b054674cfff2fc7b16bdf210ca5f0&imgtype=0&src=http%3A%2F%2Fimg.go007.com%2F2016%2F10%2F17%2F10e63bffe8d3725f_1.jpg");
                    break;
                case 10:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734105977&di=da947df072c22b9d882aa406679f34ac&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FKMk06oJDr0pgxHm6tZLr2QdwEo2nKZsHrhE1ibWScqxxiayGEuqU37MWHtysDLv1CaS0nSKDysflLeJgiahboPf3A%2F640%3Fwx_fmt%3Djpeg");
                    break;
                case 11:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734105975&di=21f8616b824a911713475afeb0673e4a&imgtype=0&src=http%3A%2F%2Fimg.tianyancha.com%2Fappbk%2F0b58ae46e2d3e313e3a5824d0fcda779.png%40%2521watermark01");
                    break;
                case 12:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=a89f1e603182e11668547a6b90cf5b3f&imgtype=0&src=http%3A%2F%2Fhrkeep.qiniudn.com%2F33084820171213134157.jpg%3Fe%3D1513147988%26token%3DGHWOwTJAHgLpFkbpgsRpoWVt3Yy58br7zawkluLu%3AA00sm7xImLrEXBOVN1y7X8cMTJA%3D");
                    break;
                case 13:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=b3c1acc6cd540e8d70f1bce57979fca1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01326755b726e632f875251fa0b1fa.jpg%401280w_1l_2o_100sh.png");
                    break;
                case 14:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=01f4db57aa87a69c362de0d7af063ae0&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F012ed0564a894e32f87512f6732c1d.jpg%40900w_1l_2o_100sh.jpg");
                    break;
                case 15:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202962&di=559240c55488b3aef3b32c52e1595af6&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c1ce581afb2aa84a0d304fcb016c.JPG%401280w_1l_2o_100sh.png");
                    break;
                case 16:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202962&di=e5861e24164c57a8657699625dd1a5df&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01951256d98f6f32f875520f2a6295.jpg");
                    break;
                case 17:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202962&di=08642c7990bb8a057c62dfbb5cbe3ca8&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01a379593f4f07a8012193a38cf8e6.png");
                    break;
                case 18:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=b3c1acc6cd540e8d70f1bce57979fca1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01326755b726e632f875251fa0b1fa.jpg%401280w_1l_2o_100sh.png");
                    break;
                case 19:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202962&di=9fdfeeea499874e5946449734b1f139d&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0165b35863c4bfa8012060c8b339ea.jpg%401280w_1l_2o_100sh.png");
                    break;
                case 20:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202962&di=b772c700c5b5f774ac07ff621057db0b&imgtype=0&src=http%3A%2F%2Fpic149.nipic.com%2Ffile%2F20171211%2F10894706_143147765000_2.jpg");
                    break;
                case 21:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=a89f1e603182e11668547a6b90cf5b3f&imgtype=0&src=http%3A%2F%2Fhrkeep.qiniudn.com%2F33084820171213134157.jpg%3Fe%3D1513147988%26token%3DGHWOwTJAHgLpFkbpgsRpoWVt3Yy58br7zawkluLu%3AA00sm7xImLrEXBOVN1y7X8cMTJA%3D");
                    break;
                case 22:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=a89f1e603182e11668547a6b90cf5b3f&imgtype=0&src=http%3A%2F%2Fhrkeep.qiniudn.com%2F33084820171213134157.jpg%3Fe%3D1513147988%26token%3DGHWOwTJAHgLpFkbpgsRpoWVt3Yy58br7zawkluLu%3AA00sm7xImLrEXBOVN1y7X8cMTJA%3D");
                    break;
                case 23:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734202963&di=01f4db57aa87a69c362de0d7af063ae0&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F012ed0564a894e32f87512f6732c1d.jpg%40900w_1l_2o_100sh.jpg");
                    break;
                case 24:
                    seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557734644858&di=b5cbc4a257c739c697dc959414aa1efa&imgtype=0&src=http%3A%2F%2Fwww.kbm8.com%2Fimage%2F180224%2F015231_2.jpg");
                    break;
				case 25:
					seller.setIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1557733576037&di=c3a6f2507da9e9914617bcc6e84b5983&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b4365ccea58aa8012141686901d4.jpg%401280w_1l_2o_100sh.jpg");
					break;
            }


            ortherSellerList.add(seller);
        }

        Response res = new Response();
        res.setCode("0");
        HomeInfo info = new HomeInfo(promotionList, categorieList, nearbySellerList, ortherSellerList);
        res.setData(JSONObject.fromObject(info).toString());
        CommonUtil.renderJson(response, res);
    }

}
