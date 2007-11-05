package planetekids.beans.stateful;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import planetekids.beans.entity.AnswerBean;
import planetekids.beans.entity.LocaleBean;
import planetekids.beans.entity.QuestionBean;
import planetekids.beans.entity.QuestionnaireBean;
import planetekids.beans.entity.ResultBean;

@Stateful
public class CustomerBean implements CustomerRemote{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void init() {
        QuestionnaireBean questionnaire = new QuestionnaireBean(new LocaleBean("Planete Kids ouvre bientot ses portes sur le net.", "Planete Kids open its doors on the web soon."),
                              new LocaleBean("Aidez-nous � cr�er un site � votre image!!!", "Help us to create a site that feets you!!!"));
        
        QuestionBean question = new QuestionBean(questionnaire, new LocaleBean("Combien d'enfants de moins de 17 ans vivent dans votre foyer?", "How many children under 17 live in your home?"), QuestionBean.Pattern.VALUE, 1);
        AnswerBean answer = new AnswerBean(question, new LocaleBean("enfant(s)", "child(ren)"), false, 1);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Quel type de connexion internet utilisez-vous?", "What kind of internet connection do you use?"), QuestionBean.Pattern.SINGLE_CHOICE, 2);
        answer = new AnswerBean(question, new LocaleBean("Connexion par modem", "Modem connection"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Connexion haut d�bit", "High band width connection"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Connexion par c�ble", "Cable connection"), false, 3);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Autres, pr�cisez :", "Other, precise :"), true, 4);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Quel navigateur internet utilisez-vous?", "What browser do you use?"), QuestionBean.Pattern.SINGLE_CHOICE, 3);
        answer = new AnswerBean(question, new LocaleBean("Internet Explorer", "Internet Explorer"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Firefox", "Firefox"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Opera", "Opera"), false, 3);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Safari", "Safari"), false, 4);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Autres, pr�cisez :", "Other, precise :"), true, 5);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Ecrivez trois mot-clef que vous utliseriez pour rechercher des vetements pour votre enfant sur le internet.", "Write three word you would use to find clothes for your children on the internet."), QuestionBean.Pattern.VALUE, 4);
        answer = new AnswerBean(question, new LocaleBean("(a)", "(a)"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("(b)", "(b)"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("(c)", "(c)"), false, 3);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("D'une mani�re g�n�rale, lorsque vous acheter sur internet, vous �tes sensible � :", "Usually, when you buy on the internet, you are sensible to :"), QuestionBean.Pattern.SORT, 5);
        answer = new AnswerBean(question, new LocaleBean("L'attractivit� des prix", "Prices attractivity"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Diversit� des produits propos�s", "Products diversity"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("La qualit� du site (Esth�tisme, facilit� d'tilisation...)", "The site quality (Esthetisme, easy to use...)"), false, 3);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Les services propos�s (Garanties, Remboursement...)", "The services (Garanty, Remboursement...)"), false, 4);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Dans lesquelles des cat�gories suivantes avez-vous acheter un produit ou un service au cours des 12 derniers mois?", "In which of these categories did you buy a product or a service during the past 12 month?"), QuestionBean.Pattern.MULTI_CHOICE, 6);
        answer = new AnswerBean(question, new LocaleBean("Produits culturels", "Cultural product"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Informatique", "Computing"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("TV, Hi-Fi", "TV, Hi-Fi"), false, 3);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Textile", "Textile"), false, 4);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Alimentation", "Food"), false, 5);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Tourisme", "Tourism"), false, 6);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Fleur", "Floxer"), false, 7);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Seriez-vous interess�s par l'achat de v�tement en ligne?", "Are you interresting in buying clothes on the web?"), QuestionBean.Pattern.SINGLE_CHOICE, 7);
        answer = new AnswerBean(question, new LocaleBean("Oui", "Yes"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Non", "No"), false, 2);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("A quelle fr�quence achetez-vous des v�tements pour vos enfants?", "How often do you buy clothes for your children?"), QuestionBean.Pattern.SINGLE_CHOICE, 8);
        answer = new AnswerBean(question, new LocaleBean("Une fois par ans", "Once a years"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("2 � 3 fois par ans", "Twice or three times a year"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Quatre fois par ans ou plus, pr�cisez :", "four times a year or more, precise :"), true, 3);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Qui choisi les v�tements pour vos enfants?", "Who choose the clothes for your children?"), QuestionBean.Pattern.SINGLE_CHOICE, 9);
        answer = new AnswerBean(question, new LocaleBean("Vous", "You"), false, 1);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Vos enfants", "Your children"), false, 2);
        question.getAnswers().add(answer);
        answer = new AnswerBean(question, new LocaleBean("Autre, pr�cisez :", "Other, precise :"), true, 3);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        question = new QuestionBean(questionnaire, new LocaleBean("Quel est votre budget annuel pour acheter des v�tements � vos enfants?", "How much do you spend a year to buy clothes to your children?"), QuestionBean.Pattern.VALUE, 10);
        answer = new AnswerBean(question, new LocaleBean("euros par an", "euro per year"), false, 1);
        question.getAnswers().add(answer);
        questionnaire.getQuestions().add(question);
        
        entityManager.persist(questionnaire);
    }
    
    public List<QuestionnaireBean> getQuestionnaires() {
        return entityManager.createNamedQuery("getQuestionnaires").getResultList();
    }
    
    public QuestionnaireBean getQuestionnaire(int questionnaire_id) {
        return entityManager.find(QuestionnaireBean.class, questionnaire_id);
    }
    
    public void createResult(int id, String value, String comment) throws Exception {
        AnswerBean answer = entityManager.find(AnswerBean.class, id);
        if(answer == null) throw new Exception("Cannot find AnswerBean : id="+String.valueOf(id));
        ResultBean result = new ResultBean(answer, value, comment);
        entityManager.persist(result);
    }
    
    @PostConstruct
    private void postConstruct() {
    }
    
    @PreDestroy
    private void preDestroy() {
    }
    
    @PostActivate
    private void postActivate() {
    }
    
    @PrePassivate
    private void prePassivate() {
    }
    
    @Remove
    private void remove() {
    }
    
}
