package ru.date.datingfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.date.datingfinder.models.HumanModel
import ru.date.datingfinder.models.Message

fun inflate(context: Context, viewId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(viewId, parent, attachToRoot)
}

fun getGirl(): HumanModel {
    return listOf(
        HumanModel(
            "Angelina",
            "Photographer",
            "https://i.pinimg.com/originals/1b/3c/7e/1b3c7e0a90b03101e175cf14598c41e4.jpg",
            23,
            false,
            Message(0, 1, "", "Angelina")
        ),
        HumanModel(
            "Sofie",
            "AnimeTyan",
            "https://trikky.ru/wp-content/blogs.dir/1/files/2020/03/01/0d533c829b0a3b7456814f7a4de8fa53.jpg",
            22,
            false,
            Message(0, 2, "", "Sofie")
        ),
        HumanModel(
            "Park Chaeyoung",
            "TikToker",
            "https://i.pinimg.com/564x/41/38/32/4138327414c19c0ab90632c01e4af34c.jpg",
            20,
            false,
            Message(0, 3, "", "Park Chaeyoung")
        ),
        HumanModel("Jennie Howells","Actor","https://images.unsplash.com/photo-1520512202623-51c5c53957df?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0, 4, "", "Jennie Howells")),
        HumanModel("Cindy Hale","Art Director","https://images.unsplash.com/photo-1578616070222-50c4de9d5ade?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,5,"","Cindy Hale")),
        HumanModel("Jorja Glenn","Artist","https://images.unsplash.com/photo-1503414265207-455bcd0955dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,6,"","Jorja Glenn")),
        HumanModel("Vivien Nixon","Auto Mechanic","https://images.unsplash.com/photo-1440589473619-3cde28941638?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",26,false, Message(0,7,"","Vivien Nixon")),
        HumanModel("Chantelle Whitney","Automotive mechanic","https://images.unsplash.com/photo-1467632499275-7a693a761056?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,8,"","Chantelle Whitney")),
        HumanModel("Isla-Grace Firth","Bookkeeping clerk","https://images.unsplash.com/photo-1539811107033-3a67f3ebc852?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,9,"","Isla-Grace Firth")),
        HumanModel("Sumayya Forster","Budget analyst","https://images.unsplash.com/photo-1502831376-280384d0fbd8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,10,"","Sumayya Forster")),
        HumanModel("Renae Ramsey","Bus Driver","https://images.unsplash.com/photo-1509122043523-bc25fa2c1d6d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,11,"","Renae Ramsey")),
        HumanModel("Thierry Beltran","Carpenter","https://images.unsplash.com/photo-1502982899975-893c9cf39028?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,12,"","Thierry Beltran")),
        HumanModel("Tyrell Delgado","Cashier","https://images.unsplash.com/photo-1589571894960-20bbe2828d0a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,13,"","Tyrell Delgado")),
        HumanModel("Dakota Davenport","Chef","https://images.unsplash.com/flagged/photo-1576212152884-614580e3d5ac?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",18,false, Message(0,14,"","Dakota Davenport")),
        HumanModel("Liyana Sharma","Chemist","https://images.unsplash.com/photo-1482555670981-4de159d8553b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,15,"","Liyana Sharma")),
        HumanModel("Chantal Reid","Childcare worker","https://images.unsplash.com/photo-1545912453-3d32e20f72bf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,16,"","Chantal Reid")),
        HumanModel("Arlo Whitehead","Civil Engineer","https://images.unsplash.com/photo-1502898295-455afaf0f015?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,17,"","Arlo Whitehead")),
        HumanModel("Addie Moreno","Clinical Laboratory Technician","https://images.unsplash.com/photo-1541971297127-c4e6f05297da?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,18,"","Addie Moreno")),
        HumanModel("Tahmina Davies","Coach","https://images.unsplash.com/photo-1441123100240-f9f3f77ed41b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",24,false, Message(0,19,"","Tahmina Davies")),
        HumanModel("Selin Dalby","College Professor","https://images.unsplash.com/photo-1547147607-6eab7b49f3ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,20,"","Selin Dalby")),
        HumanModel("Alyx Lu","Compliance Officer","https://images.unsplash.com/photo-1546052646-a88eafec0399?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,21,"","Alyx Lu")),
        HumanModel("Kiera Le","Computer Hardware Engineer","https://images.unsplash.com/photo-1594058374296-33aa9cae524a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,22,"","Kiera Le")),
        HumanModel("Amritpal Sellers","Computer Programmer","https://images.unsplash.com/photo-1566219094625-41fd3bc1ea5e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,23,"","Amritpal Sellers")),
        HumanModel("Shaan Ashley","Computer Support Specialist","https://images.unsplash.com/photo-1596566263618-46778ebc6121?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,24,"","Shaan Ashley")),
        HumanModel("Kloe Odonnell","Computer Systems Administrator","https://images.unsplash.com/photo-1583843364289-0d1b2978874c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,25,"","Kloe Odonnell")),
        HumanModel("Poppy-Rose Oconnor","Computer Systems Analyst","https://images.unsplash.com/photo-1591361796603-01599a42e701?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",18,false, Message(0,26,"","Poppy-Rose Oconnor")),
        HumanModel("Collette Zavala","Construction Manager","https://images.unsplash.com/photo-1565699774381-d421d9e7ad41?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,27,"","Collette Zavala")),
        HumanModel("Blanka Dyer","Cost Estimator","https://images.unsplash.com/photo-1587140029742-e23f5c300237?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,28,"","Blanka Dyer")),
        HumanModel("Cian Rawlings","Court Reporter","https://images.unsplash.com/photo-1596815064285-45ed8a9c0463?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,29,"","Cian Rawlings")),
        HumanModel("Lilly-Mai Barnard","Customer Service Representative","https://images.unsplash.com/photo-1552994281-1b25d423041c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,30,"","Lilly-Mai Barnard")),
        HumanModel("Ira Whittaker","Dancer","https://images.unsplash.com/photo-1594745561149-2211ca8c5d98?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,31,"","Ira Whittaker")),
        HumanModel("Shanae Dotson","Database administrator","https://images.unsplash.com/photo-1507229943010-31ed01024f05?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,32,"","Shanae Dotson")),
        HumanModel("Lilly-May Grey","Dental Hygienist","https://images.unsplash.com/photo-1561997895-2e5d84cc3ac2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",22,false, Message(0,33,"","Lilly-May Grey"))

    ).shuffled()[1]
}
fun getMan(): HumanModel {
    return listOf(
        HumanModel("Colin Wharton","Actuary","https://images.unsplash.com/photo-1567784177951-6fa58317e16b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,1,"","Colin Wharton")),
        HumanModel("Chester Gates","Food Scientist","https://images.unsplash.com/photo-1546215364-12f3fff5d578?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,2,"","Chester Gates")),
        HumanModel("Shawn Read","Anthropologist","https://images.unsplash.com/photo-1495706891067-35a06798dbca?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,3,"","Shawn Read")),
        HumanModel("Arman Velasquez","Architect","https://images.unsplash.com/photo-1590086782792-42dd2350140d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,4,"","Arman Velasquez")),
        HumanModel("Caiden Maynard","Art Director","https://images.unsplash.com/photo-1480429370139-e0132c086e2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,5,"","Caiden Maynard")),
        HumanModel("Montell Jackson","Artist","https://images.unsplash.com/photo-1558224523-1c255516fddf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,6,"","Montell Jackson")),
        HumanModel("Sierra Christian","Auto Mechanic","https://images.unsplash.com/photo-1588731234159-8b9963143fca?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",26,false, Message(0,7,"","Sierra Christian")),
        HumanModel("Bradley Reyna","Automotive mechanic","https://images.unsplash.com/flagged/photo-1574874897534-036671407eda?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,8,"","Bradley Reyna")),
        HumanModel("Bentley Carey","Bookkeeping clerk","https://images.unsplash.com/photo-1489913590284-9269438bb411?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,9,"","Bentley Carey")),
        HumanModel("Hope Madden","Budget analyst","https://images.unsplash.com/photo-1495874418447-4a9bab856d0b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,10,"","Hope Madden")),
        HumanModel("Veer Plummer","Bus Driver","https://images.unsplash.com/photo-1582804905556-0605e6433015?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,11,"","Veer Plummer")),
        HumanModel("Daanyaal Head","Carpenter","https://images.unsplash.com/photo-1582439170934-d089aa10abda?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,12,"","Daanyaal Head")),
        HumanModel("Kiki Paterson","Cashier","https://images.unsplash.com/photo-1508341591423-4347099e1f19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,13,"","Kiki Paterson")),
        HumanModel("Haiden Feeney","Chef","https://images.unsplash.com/photo-1541577141970-eebc83ebe30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",18,false, Message(0,14,"","Haiden Feeney")),
        HumanModel("Nazim Mohammed","Chemist","https://images.unsplash.com/photo-1588731247530-4076fc99173e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,15,"","Nazim Mohammed")),
        HumanModel("Teejay Roth","Childcare worker","https://images.unsplash.com/photo-1484515991647-c5760fcecfc7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,16,"","Teejay Roth")),
        HumanModel("Cally Finnegan","Civil Engineer","https://images.unsplash.com/photo-1495605952598-956edca588a4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,17,"","Cally Finnegan")),
        HumanModel("Perry Buck","Clinical Laboratory Technician","https://images.unsplash.com/photo-1542190891-2093d38760f2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,18,"","Perry Buck")),
        HumanModel("Shayan Cervantes","Coach","https://images.unsplash.com/photo-1543084951-1650d1468e2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",24,false, Message(0,19,"","Shayan Cervantes")),
        HumanModel("Jonty Carty","College Professor","https://images.unsplash.com/photo-1558521432-23ac0222f962?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,20,"","Jonty Carty"))
    ).shuffled()[1]
}