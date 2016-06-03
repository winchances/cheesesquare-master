package com.example.mydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by wenc on 2016/5/30.
 */
public class NewsDetailFragment extends Fragment {
    View view;
    String str;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_detail,container,false);

        str = "<!--IMG#0--><!--IMG#1--><p>　　新华社广州5月30日新媒体专电（“新华视点”记者陈寂、毛一竹）28日，广东省江门台山市端芬镇凤凰峡旅游区发生一起事故，游客漂流遇山洪袭击，致8人不幸死亡，6人获救。事故前，气象部门连续发布两次预警：受今年首个热带低压影响，江门地区将有暴雨至大暴雨。然而，两道暴雨预警，却未能阻挡“夺命漂流”照常营业。</p><p>　　在29日举行的新闻发布会上，记者甚至看到了地方政府主管部门“互踢皮球”的场面：台山市旅游局坚称，凤凰峡非A级风景区，漂流项目由体育局发放执照。台山市体育局承认向涉事企业发放了执照，但坚称安全监管是旅游局的责任。</p><p>　　<b>夺命漂流，究竟是“天灾”还是“人祸”？</b></p><p>　　<strong>漂流遇洪水8人死亡监管部门“互踢皮球”</strong></p><p>　　今年首个热带低压于27日在广东登陆。26日至28日，台山市气象局先后发布暴雨蓝色预警信号、暴雨橙色预警信号，提示防御强降雨及其引发的山洪、山体滑坡等灾害。</p><p>　　然而，两次暴雨预警，未能挡住凤凰峡景区的漂流，以致酿成生命惨剧。</p><p>　　广东省江门市应急办28日披露，多名游客当日下午在凤凰峡旅游区漂流时，突遇山洪暴发。经当地紧急搜救，至当天19时10分，搜救上来生还者6人，死亡5人，失踪3人。29日中午，台山市政府举行新闻发布会，披露死亡人数增加至8人，未核查到新的失踪人员。</p><p>　　游客们惊魂未定，监管部门却在新闻发布会上“互踢皮球”。</p><p>　　在29日中午举行的事故新闻发布会上，台山市旅游局长魏思远说，接到气象局的预警信息之后，旅游局27日将天气情况和安全排查的要求用手机短信转发给该景区的运营企业——金凤凰旅游公司的负责人。“现场是否落雨、气候水文是否适合漂流，还需要现场景区确定”。</p><p>　　“由于凤凰峡景区不是国家A级景区，旅游局没有管理权限。”魏思远说，景区漂流项目的相关牌照由体育部门按照国家体育总局高危行业的管理办法颁发，不属于旅游局职权范围。</p><p>　　台山市体育局局长李逸波说，该企业已经办理了行政许可，属于有证经营。他表示，上个月25日已经在一个会议上，明确要求该企业负责人在遇到大风雨天气时，要关闭项目。“但是这种天气预报的情况，变幻莫测，我们虽然提出了要求，但我们不能强制企业关停”。</p><p>　　当记者问道“天气已经非常恶劣，他们还不关停，那怎么办”时，出席发布会的政府部门负责人均陷入了沉默。在暴雨橙色预警发出到事故发生之间，“旅游和体育部门有没有做好旅客疏导？”“有没有督促企业落实安全工作？”相关负责人对此都没有正面回答。</p><p>　　广东省旅游局有关负责人也表示，凤凰峡不是A级景区，由体育部门发牌照，目前不由该局管理。</p><p>　　记者采访了解到，目前，关于漂流旅游的行业标准及运营规范还没有出台。如何应对各种异常天气，企业自主决定。</p><p>　　<b>凤凰峡景区负责人已经被控制，记者未能采访到</b></p><p>　　<strong>“野生”漂流无人监管“无知”游客懵懂冒险</strong></p><p>　　据媒体报道，近年来，广西、浙江、重庆、湖南等地已发生多起致人死亡的漂流安全事故。其共同特点就是忽视暴雨天气等安全因素，部分漂流点甚至处于“野生”状态，事发之后才发现无人监管。</p><p>　　记者29日来到事故发生的凤凰岭景区，景区门口售票处显示漂流项目包括“军事漂流”“激情生态漂”两项，票价分别为148元和68元。景区售票处已经关门，景区门�";
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HtmlTextView htNewsContent= (HtmlTextView) view.findViewById(R.id.htNewsContent);
        htNewsContent.setHtmlFromString(str, new HtmlTextView.LocalImageGetter());

    }
}
