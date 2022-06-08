import java.util.regex.Pattern;
import javax.swing.*;

public class App {
    // Array for storing user response
    private final String[] answers = new String[10]; // {null, null, null... 10}

    // Pattern for checking if the user inputs are valid
    private final String[] pattern = {
        "^([A-z][A-z]+|[A-z][A-z]+ [A-z][A-z]+|[A-z]+ [A-z]+ [A-z]+)$", // ? FN or FN SN or FN MD SN ?
        "^([1-9]|[1-9][0-9]|[1][0]{2})$", // ? Age ?
        "^(January|February|March|April|May|June|July|August|September|October|November|December) ([1-9]|[0][1-9]|[1-2][0-9]|3[0-1])$", // ? Month Day ?
        "^[A-z].+$", // ? Dream Job ? 
        "^(Yes|No)$", // ? Friends ? Yes/No
        "^((Cat|Dog) Person)$", // ? Cat/Dog ? I am a cat person
        "^(Yes|No)$", // ? Joke ? Yes/No
        "^(Yes|No)$", // ? Place ? Yes/No
        "^[A-z].+$", // ? Favorite Food ?
        "^(Yes|No)$" // ? Phone Number ? Yes/No
    };

    public static void main(String[] args) throws Exception {
        startStory();
    }

    // startStory method will start to ask 10 questions.
    private static void startStory() {
        App app = new App();
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        // * For Loop for 10 questions
        for(int index = 0; index < 11; index++) {
            // * Send message
            if(index == 0) JOptionPane.showMessageDialog(frame, getGreeting(), "Bernard Sapida greeting's message", JOptionPane.PLAIN_MESSAGE);
            if(index == 1) JOptionPane.showMessageDialog(frame, getCompliments(app), "Bernard Sapida is complimenting you!", JOptionPane.PLAIN_MESSAGE);
            if(index == 2) JOptionPane.showMessageDialog(frame, getAgeResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 3) JOptionPane.showMessageDialog(frame, getBirthdayResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 4) JOptionPane.showMessageDialog(frame, "<html><body><div style='display: grid; align-items: center; justify-content: center;'><p style='text-align: center; width: 200px;'><img src='https://scontent.fcrk1-4.fna.fbcdn.net/v/t39.30808-6/244423265_880397335946403_819700225320128604_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=e3f864&_nc_eui2=AeGO-uP0YAWmaKJ47aagHXEOnuZbkRdgc1ee5luRF2BzV04HI2YRE0b6nSd4S1g4xLQUtEVuMReXoniRWJhjuUeK&_nc_ohc=PgtBmdhRBq8AX_FGTuv&_nc_ht=scontent.fcrk1-4.fna&oh=00_AT9347mFYHA0nq5iyY6NSiyX4SqdxyYyuXGYR5jQHWQrKA&oe=623F761D' width='180' height='100'></p><h2 style='color: rgba(15, 15, 15, 0.9); text-align: center;'>Bernard Sapida say: </h2><p style='color: rgba(15, 15, 15, 0.9); text-align: center;'>WOW! My dream job is to become a Software Engineer on big tech companies such as Google, Meta, Amazon, or Netflix.</p><div></bod></html>", "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 5) JOptionPane.showMessageDialog(frame, getFriendsResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 6) JOptionPane.showMessageDialog(frame, getAnimalResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 7) JOptionPane.showMessageDialog(frame, getJokeResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 8) JOptionPane.showMessageDialog(frame, getPlaceResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 9) JOptionPane.showMessageDialog(frame, getFavoriteDishResponse(app), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
            if(index == 10) JOptionPane.showMessageDialog(frame, getPhoneNumberResponse(app, frame), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);

            // * Get feedback from chatmate.
            // * getQuestion(answers[0] = name, index = questions)
            if(index < 10) {
                String feedback = (index == 4 || index == 6 || index == 7 || index == 9) ? 
                                JOptionPane.showConfirmDialog(frame, app.getQuestion(app, index), "Bernard Sapida is asking", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0 ? "Yes" : "No" :
                                JOptionPane.showInputDialog(frame, app.getQuestion(app, index), "Bernard Sapida is asking", JOptionPane.PLAIN_MESSAGE);
                // ? Check user input if valid.
                // ? If true then negate it to become false and stop the iteration
                // ? If false then negate it to become true and start the iteration to ask for valid input.
                while(!Pattern.compile(app.pattern[index]).matcher(capitalizeString(feedback)).find()) {
                    // ? If user input is invalid then ask again.
                    getErrorMessage(frame);
    
                    // ? Store the new input on feedback variable and check on while condition.
                    feedback = (index == 4 || index == 6 || index == 7 || index == 9) ? 
                               JOptionPane.showConfirmDialog(frame, app.getQuestion(app, index), "Bernard Sapida is asking", JOptionPane.YES_NO_OPTION) == 0 ? "Yes" : "No" :
                               JOptionPane.showInputDialog(frame, app.getQuestion(app, index), "", JOptionPane.PLAIN_MESSAGE);
                }
    
                // * Store the feedback on answer array.
                app.setAnswer(capitalizeString(feedback), index);
            }
        }

        // Show goodbye message dialog
        JOptionPane.showMessageDialog(frame, getHTML("https://th.bing.com/th/id/R.d7868a006ca700ccf5d21cdea80fec27?rik=ycd2e8rZE83LkA&riu=http%3a%2f%2fwww.pngmart.com%2ffiles%2f12%2fHappy-Emoji-PNG-File.png&ehk=d4OgA94bsms07LaBekhxOgickzAVVKfhawE8euzotAo%3d&risl=&pid=ImgRaw&r=0", app.getAnswer()[0] + ", I need to end our conversation since I need to do something, I want to say that I have your details such as you are " + app.getAnswer()[1] + " years old, " + " your birthday is " + app.getAnswer()[2] + ", you are a " + app.getAnswer()[5].toLowerCase() + ", " + "and when I ask you about if you know where tagaytay is, you said '" + app.getAnswer()[7] + "'. Since you said " + app.getAnswer()[8].toLowerCase() + " is your favorite dish. Therefore, I will try to order your favorite dish when we go to Tagaytay. " + (Pattern.compile("^(09|08)[0-9][0-9]-[0-9]{3}-[0-9]{4}$").matcher(app.getAnswer()[9]).find() ? "I will contact your phone#: " + app.getAnswer()[9] + " once I finished my task. By the way, my phone# is 0947-212-6029! I'm enjoying chatting with you, keep safe and enjoy your day! Thank youuuuu!" : "")), "Bernard Sapida reponse message!", JOptionPane.PLAIN_MESSAGE);
    }

    // VarName = Value;
    private void setAnswer(String value, int index) {
        this.answers[index] = value;
    }

    // System.out.println(VarName)
    private String[] getAnswer() {
        return this.answers;
    }

    // getQuestion method will return a question to ask for users
    private String getQuestion(App app, int index) {
        String name = app.getAnswer()[0];

        String[] questions = {
        /* 0 */    "Since this is my first day with you. What is your name?", // ? Name ?
        /* 1 */    "How old are you? (Example: 28)", // ? Age ?
        /* 2 */    "I would like to know " + name + " when is your birthday? (Format: Month Day)", // ? Birthday ?
        /* 3 */    name + ", what is your dream job?", // ? Dream Job ?
        /* 4 */    "I want you to be my friend " + name + ", would you?", // ? Friends ? Yes/No
        /* 5 */    "Are you a cat person or a dog person? (Answer: Cat Person or Dog Person)", // ? Cat/Dog ? I am a cat person
        /* 6 */    "Did you know why can't a bike stand on its own?", // ? Joke ? Yes/No
        /* 7 */    name + ", do you know where Tagaytay is?", // ? Place ? Yes/No
        /* 8 */    "I would like to know what is your favorite food " + name + "?", // ? Favorite Food ?
        /* 9 */    name + ", may I get your phone number?" // ? Phone Number ? Yes/No
        };

        return getHTML("https://th.bing.com/th/id/R.26bff40e355c165284760b708a782b4f?rik=tnWOh4gdGRL40A&riu=http%3a%2f%2fclipart-library.com%2fimages%2f6TrooeX8c.png&ehk=SRgv3Q%2bdCT2TRMIfoB%2f39uWqSZNxEp%2bwPjPSNaaavF8%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1", questions[index]);
    }

    // getGreeting method will return a random greeting for users
    private static String getGreeting() {
        String[] greetings = {
            "Hello there, I'm Bernard Sapida! A blessed day to you.",
            "Hello there, I'm Bernard Sapida! A pleasure to meet you.",
            "Hello there, I'm Bernard Sapida! Greetings and salutations.",
            "Hello there, I'm Bernard Sapida! Good day to you.",
            "Hello there, I'm Bernard Sapida! Great to meet you.",
            "Hello friend, my name is Bernard Sapida.",
            "Hey! I'm Bernard Sapida and I want to be friends with you.",
            "Matey! My name is Bernard Sapida and nice to meet you.",
            "Howdy! My name is Bernard Sapida and I'm glad to meet you."
        };

        return getHTML("https://th.bing.com/th/id/R.b2dd112c9917773a2b6d77b626f24a97?rik=bSID3H1CUVkz1g&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2fc%2f9%2f5%2ff%2fc95f50583d59aae7d792dd5fdc333196.png&ehk=RD6u83S2hu7U%2f3GVV598LlUf4AsltSNqHtuUxsVc%2fK8%3d&risl=&pid=ImgRaw&r=0", getRandom(greetings));
    }

    // getCompliments method will return a random compliment for users
    private static String getCompliments(App app) {
        String name = app.getAnswer()[0];
        String[] compliments = {
            "Are you a celebrity? I like your name " + name,
            "My mom said I shouldn't talk to strangers like you " + name + ", but you don't look scary.",
            "Wow, you have a wonderful name " + name + ".",
            name + ", you caught my attention so I just had to come talk to you.",
            name + ", you seem like a nice person.",
            name + ", your are looking good.",
            name + ", you have this friendly aura around you."
        };
        
        return getHTML("https://th.bing.com/th/id/R.2f35d9d13cea24ae8863d51ac6b4902e?rik=AqwEoweZl4rMSg&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f7%2f5%2fe%2fe%2f75ee75dd6c3f4c85b51afebfa550f9ea.png&ehk=RLv68d0AWTV1hYjqG%2fm0jwTVKpvQbccmIlaIYhozdlo%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1", getRandom(compliments));
    }

    // getAgeResponse method will return a random message regarding to age of users
    private static String getAgeResponse(App app) {
        String bernardResponse = "";
        String userName = app.getAnswer()[0];
        int userAgeResponse = Integer.parseInt(app.getAnswer()[1]);
        int value = userAgeResponse >= 1 && userAgeResponse <= 10 ? 1 : userAgeResponse > 10 && userAgeResponse <= 19 ? 2 : 3;

        switch(value){
            case 1 -> { bernardResponse = "So cute! I am " + (19 - userAgeResponse) + "years older than you " + userName + ". I'm 19 years old and you can call me brother. :D"; }
            case 2 -> { bernardResponse = "Wow! You are a teenager too " + userName + "! We're the same since I'm just 19 years old" + ((19 - userAgeResponse) == 0 ? "" : " and you are " + (19 - userAgeResponse) + "years younger than me") + "."; }
            case 3 -> { bernardResponse = "Ohhh! You are " + (userAgeResponse - 19) +"years older than me "+ userName + ". I'm just 19 years old and I'm glad to meet you! ;D"; }
        }

        return getHTML("https://th.bing.com/th/id/R.b2dd112c9917773a2b6d77b626f24a97?rik=bSID3H1CUVkz1g&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2fc%2f9%2f5%2ff%2fc95f50583d59aae7d792dd5fdc333196.png&ehk=RD6u83S2hu7U%2f3GVV598LlUf4AsltSNqHtuUxsVc%2fK8%3d&risl=&pid=ImgRaw&r=0", bernardResponse);
    }

    // getBirthdayResponse method will return a message regarding the age gap between Me and Users
    private static String getBirthdayResponse(App app) {
        String userBirthdayResponse = app.getAnswer()[2];
        String zodiacSign = "";
        String imageLink = "";
        String month = userBirthdayResponse.substring(0, userBirthdayResponse.indexOf(" "));
        int day = Integer.parseInt(userBirthdayResponse.substring(userBirthdayResponse.indexOf(" ")+1));

        switch(month) {
            case "January" -> { zodiacSign = day >= 20 ? "Aquarius" : "Capricorn"; }
            case "February" -> { zodiacSign = day >= 19 ? "Pisces" : "Aquarius"; }
            case "March" -> { zodiacSign = day >= 21 ? "Aries" : "Pisces"; }
            case "April" -> { zodiacSign = day >= 20 ? "Taurus" : "Aries"; }
            case "May" -> { zodiacSign = day >= 21 ? "Gemini" : "Taurus"; }
            case "June" -> { zodiacSign = day >= 21 ? "Cancer" : "Gemini"; }
            case "July" -> { zodiacSign = day >= 23 ? "Leo" : "Cancer"; }
            case "August" -> { zodiacSign = day >= 23 ? "Virgo" : "Leo"; }
            case "September" -> { zodiacSign = day >= 23 ? "Libra" : "Virgo"; }
            case "October" -> { zodiacSign = day >= 23 ? "Scorpio" : "Libra"; }
            case "November" -> { zodiacSign = day >= 22 ? "Sagittarius" : "Scorpio"; }
            case "December" -> { zodiacSign = day >= 22 ? "Capricorn" : "Sagittarius"; }
        };

        switch(zodiacSign) {
            case "Capricorn" -> { imageLink = "https://pngimg.com/uploads/capricorn/capricorn_PNG1.png"; }
            case "Aquarius" -> { imageLink = "https://clipground.com/images/aquarius-png-8.png"; }
            case "Pisces" -> { imageLink = "https://pngimg.com/uploads/pisces/pisces_PNG15.png"; }
            case "Aries" -> { imageLink = "https://th.bing.com/th/id/OIP.tCvAJTqqgxMvpp7JSuEnBQHaI0?pid=ImgDet&rs=1"; }
            case "Taurus" -> { imageLink = "https://th.bing.com/th/id/R.74aede579bcdb747ff0d8456ea7490eb?rik=Pihmnly48NM6Pw&riu=http%3a%2f%2fwww.pngmart.com%2ffiles%2f5%2fTaurus-PNG-Transparent-Image.png&ehk=MKazbgM%2fGA4TTiex5wgMaX9brbHRVqW85zimwqLytxI%3d&risl=&pid=ImgRaw&r=0"; }
            case "Gemini" -> { imageLink = "https://pngimg.com/uploads/gemini/gemini_PNG42.png"; }
            case "Cancer" -> { imageLink = "https://th.bing.com/th/id/OIP.93K6TaOZ9NBYwc03lJMAhwHaFe?pid=ImgDet&rs=1"; }
            case "Leo" -> { imageLink = "https://th.bing.com/th/id/R.f49b3a43cf8b1a41558d10c811912206?rik=8FTJ%2bwcGRvTniQ&riu=http%3a%2f%2fassets.stickpng.com%2fthumbs%2f5858eb964f6ae202fedf2801.png&ehk=iiqDPZsVkrsNwRbeeLT7oe%2feCcbigiji7A%2f0t5dmLmA%3d&risl=&pid=ImgRaw&r=0"; }
            case "Virgo" -> { imageLink = "https://th.bing.com/th/id/R.a9986b37133a7683c0c9b4c0d2b261f6?rik=x1xyzwTrJfDwKA&riu=http%3a%2f%2fwww.pngmart.com%2ffiles%2f5%2fVirgo-PNG-Pic.png&ehk=TlyTM9LpYbr0aXY5x0Ef%2f7s2zyoFDcJEwHatzz%2fiy1M%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1"; }
            case "Libra" -> { imageLink = "https://pngimg.com/uploads/libra/libra_PNG19.png"; }
            case "Scorpio" -> { imageLink = "https://th.bing.com/th/id/R.30b777e15fc88e94c958d7f611d620b8?rik=JSy8K%2b0z%2bkUERQ&riu=http%3a%2f%2fclipart-library.com%2fimages_k%2ftransparent-scorpio%2ftransparent-scorpio-15.png&ehk=INRB7ogvspu%2f1XMae4JaWzA7xOD1yzE%2fqekbzMgZkcA%3d&risl=&pid=ImgRaw&r=0"; }
            case "Sagittarius" -> { imageLink = "https://www.pngarts.com/files/2/Sagittarius-Transparent-Image.png"; }
        }

        return getHTML(imageLink, "Since your birth month is " + month + " and your birth day is " + day + ". Therefore, your zodiac sign is " + zodiacSign + ".");
    }
     
    // getFriendsResponse method will return a message regarding if user are willing to be my friend. (Yes/No)
    private static String getFriendsResponse(App app) {
        String[] userFriendResponse = app.getAnswer();
        String bernardResponse = (userFriendResponse[4].equals("Yes")) ? "I'm happy to have a new friend like you " + userFriendResponse[0] + "!" :  "It's okay " + userFriendResponse[0] + " and I will do my best for you to be my friend!";
        String htmlResult = getHTML("https://th.bing.com/th/id/R.2f35d9d13cea24ae8863d51ac6b4902e?rik=AqwEoweZl4rMSg&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f7%2f5%2fe%2fe%2f75ee75dd6c3f4c85b51afebfa550f9ea.png&ehk=RLv68d0AWTV1hYjqG%2fm0jwTVKpvQbccmIlaIYhozdlo%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1", bernardResponse);
        return htmlResult;
    }

    // getAnimalResponse method will return a message regarding if user is a Cat or Dog Person.
    private static String getAnimalResponse(App app) {
        String[] userAnimalResponse = app.getAnswer();
        String bernardResponse = "<p style='text-align: left'> Since you are a " + (userAnimalResponse[5].equals("Cat Person") ? "cat" : "dog") + " person,</p>" + ((userAnimalResponse[5].equals("Cat Person") ? "<p style='text-align: left;'>• You are independent owner and like to be autonomous and content with alone time.</p><p style='text-align: left;'>• You tends to be creative and imaginative to find it easier to come up with original ideas and novel solutions.</p><p style='text-align: left;'>• You are witty and sarcastic and like to have a good sense of humor. You enjoy satires and ironic puns.</p><p style='text-align: left;'>• You are open to new experiences due to your curious nature, you tends to be more adventurous and courageous.</p><p style='text-align: left;'>• You could be over-cautious and reserved, you are generally guarded people and have a more cautious approach in life.</p><p style='text-align: left;'>• You values affection often and need constant assurances. Therefore, the value and cherish endearments.</span>" :  "<p style='text-align: left !important;'>• You are tough-minded With their ability to focus more on situations instead of emotions, you tends to possess tough-mindedness.</p><p>• You are sociable and outgoing according to huffington post, and author Rachael Rettner, you gets comfortable in social gatherings so easily that every individual becomes your best friend.</p><p style='text-align: left;'>• You take pleasure in companionship with a heart full of compassion and benevolence, you can prove to be the best life companion.</p><p style='text-align: left;'>• You are efficient planner due to your strong sense of duty and self-discipline and you are pragmatic and an effective planner too.</p><p style='text-align: left;'>• You are agreeable person and usually altruistic, kind and owns a selfless concern for others’ welfare.</p><p style='text-align: left;'>• You are loyal and devoted being a true friend and protector, you are extremely loyal to your loved ones and will always stand by their side.</p>"));
        String htmlResult = getHTML("https://th.bing.com/th/id/R.2f35d9d13cea24ae8863d51ac6b4902e?rik=AqwEoweZl4rMSg&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f7%2f5%2fe%2fe%2f75ee75dd6c3f4c85b51afebfa550f9ea.png&ehk=RLv68d0AWTV1hYjqG%2fm0jwTVKpvQbccmIlaIYhozdlo%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1", bernardResponse);
        return htmlResult;
    }

    // getAnimalResponse method will return a message regarding if user is a Cat or Dog Person.
    private static String getJokeResponse(App app) {
        String[] userJokeResponse = app.getAnswer();
        String bernardResponse = (userJokeResponse[6].equals("Yes")) ? "Wow you knew it! A bike can't stand on its own because it's two tired! HAHAHAHAHAHA!" :  "A bike can't stand on its own because it's two tired. HAHAHAHAHA! ";
        String htmlResult = getHTML("https://th.bing.com/th/id/R.c8872c0c3bd72a0e5dcf7793fe9438c3?rik=fhf%2bDN50PddRpg&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f3%2f0%2f7%2f4%2f3074da8a9066ae54e3bd0e32084e414b.png&ehk=W2V5VRMtU35GmBf6O7iMF5yD%2bJS1l5dLPIK5lAVDfJs%3d&risl=&pid=ImgRaw&r=0", bernardResponse);
        return htmlResult;
    }

    // getPlaceResponse method will return a random message regarding if user know where Tagaytay is.
    private static String getPlaceResponse(App app) {
        String userName = app.getAnswer()[0];
        String userPlaceResponse = app.getAnswer()[7];
        String bernardResponse = "";

        switch(userPlaceResponse) {
            case "Yes" -> { bernardResponse = userName + ", I want to hangout with you soon in Tagaytay since you know where it is! There are lots of tourists spot in there and restaurants."; }
            case "No" -> { bernardResponse = userName + ", I want to hangout with you soon in Tagaytay and I promise you'll like this place! There are lots of tourists spot in there and restaurants."; }
        }
        
        return getHTML("https://www.alltherooms.com/blog/wp-content/uploads/2018/01/Tagaytay-Beach-hut-By-Anna-ART-768x514.jpg", bernardResponse);
    }

    // getFavoriteFoodResponse method will return a random message regarding to Users Favorite Food.
    private static String getFavoriteDishResponse(App app) {
        String[] userFavoriteDish = app.getAnswer();
        String[] bernardReponse = {"Horray! " + userFavoriteDish[8] + " was one of my favorite food and kare-kare!", "Wow! I like " + userFavoriteDish[8] + " too!"};
        return getHTML("https://th.bing.com/th/id/R.a3f5aedd7452e6d6dc0f940a8c7fa750?rik=yQOdY2ch2U9%2b%2bw&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f0%2f8%2f8%2f6%2f0886f82cc5ff644ba2c7e31db0913b55.png&ehk=sJT9q56pZcTD3WAzwnoMIzWZcOWHMRrd3LV%2fEBY%2fdtA%3d&risl=&pid=ImgRaw&r=0", getRandom(bernardReponse));
    }

    // getPlaceResponse method will return a random message regarding if user know where Tagaytay is.
    private static String getPhoneNumberResponse(App app, JFrame frame) {
        String userName = app.getAnswer()[0];
        String bernardResponse = "";
        if(app.getAnswer()[9].equals("Yes")) {
            String phoneNumber = JOptionPane.showInputDialog(frame, "<html><p style='text-align: center;'><img src='https://th.bing.com/th/id/R.26bff40e355c165284760b708a782b4f?rik=tnWOh4gdGRL40A&riu=http%3a%2f%2fclipart-library.com%2fimages%2f6TrooeX8c.png&ehk=SRgv3Q%2bdCT2TRMIfoB%2f39uWqSZNxEp%2bwPjPSNaaavF8%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1' width='130' height='100'></p><h2 style='color: rgba(15, 15, 15, 0.9); width: 300px; text-align: center;'>Bernard Sapida say:</h2><p style='text-align: center;'>" + userName + ", what is your phone number? (Format: 0947-212-6029)</p></html>", "Bernard Sapida is requesting", JOptionPane.PLAIN_MESSAGE);
            while(!Pattern.compile("^(09|08)[0-9][0-9]-[0-9]{3}-[0-9]{4}$").matcher(phoneNumber).find()) {
                // ? If user input is invalid then ask again.
                getErrorMessage(frame);

                // ? Store the new input on feedback variable and check on while condition.
                phoneNumber = JOptionPane.showInputDialog(frame, "<html><p style='text-align: center;'><img src='https://th.bing.com/th/id/R.26bff40e355c165284760b708a782b4f?rik=tnWOh4gdGRL40A&riu=http%3a%2f%2fclipart-library.com%2fimages%2f6TrooeX8c.png&ehk=SRgv3Q%2bdCT2TRMIfoB%2f39uWqSZNxEp%2bwPjPSNaaavF8%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1' width='130' height='100'></p><h2 style='color: rgba(15, 15, 15, 0.9); width: 300px; text-align: center;'>Bernard Sapida say:</h2><p style='text-align: center;'>" + userName + ", What is your phone number? (Format: 0947-212-6029)</p></html>", "Bernard Sapida is requesting", JOptionPane.PLAIN_MESSAGE);
            }

            // * Store the feedback on answer array.
            app.setAnswer(phoneNumber, 9);
            bernardResponse = "Thank you for giving me your phone number! I saved it on my contact.";
        }
        if(app.getAnswer()[9].equals("No")) bernardResponse = "Since you didn't give your phone number, my phone# is 0947-212-6029.";
        return getHTML("https://th.bing.com/th/id/R.60d5c1a1df74884cb232ac65e3c1a508?rik=tORQCOu16HXnZA&riu=http%3a%2f%2fwww.i2symbol.com%2fpictures%2femojis%2f1%2f7%2f6%2fd%2f176ddf308ac2b261f77299113d78faf6_384.png&ehk=czCAvVJ8IF3tjaZEX2ys%2fgiKRnk7JJL4WwXSOJ2Vk34%3d&risl=&pid=ImgRaw&r=0", bernardResponse);
    }
    
    // getHTML method will return a HTML code for dialog
    private static String getHTML(String imageLink, String paragraph) {
        return "<html>" +
                    "<p style='text-align: center; width: 400px;'><img src='" + imageLink + "' width='130' height='100'></p>"+
                    "<h1 style='color: rgba(15, 15, 15, 0.9); font-size: 16px; width: 400px; text-align: center;'>Bernard Sapida say:</h1>"+
                    "<p style='color: rgba(15, 15, 15, 0.9); font-size: 12px; width: 400px; text-align: center;'>" + paragraph + "</p>"+
                "</html>";
    }

    // getErrorMessage method will popup a dialog about incorrect input
    private static void getErrorMessage(JFrame frame) {
        JOptionPane.showMessageDialog(frame, "<html>" + "<p style='text-align: center; width: 200px;'><img src='https://www.shitpostbot.com/img/sourceimages/hmmm-think-59d927161b8fe.png' width='100' height='100'></p>" + "<h2 style='color: rgba(15, 15, 15, 0.9); text-align: center;'>Bernard Sapida say: </h2>" + "<p style='color: rgba(15, 15, 15, 0.9); text-align: center;'>I think your message is invalid, please try again!</p>" + "</html>", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
    }

    // getRandom method will return a random array inside the parameter arr.
    private static String getRandom(String[] arr) {
        return arr[(int) (Math.floor(Math.random()*arr.length))];
    }

    // capitalizeString method will capitalize first letter of each word.
    private static String capitalizeString(String string) {
        String words = "";
        for(int i = 0; i < string.split("").length; i++) {
            if (i == 0) words += string.split("")[i].toUpperCase();
            if (i != 0) words += string.split("")[i-1].equals(" ") ? string.split("")[i].toUpperCase() : string.split("")[i].toLowerCase();
        }
        return words;
    }
}