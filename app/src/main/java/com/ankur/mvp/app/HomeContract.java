package com.ankur.mvp.app;

import com.ankur.mvp.app.model.Question;
import java.util.List;

/**
 * Created by ANKUR JAIN on 27-06-2017.
 */

public interface HomeContract {
    interface View {
        void showErrors();
        void hideProgressBar();
        void setDataInList(List<Question> questions);
    }

    interface Presenter {
        void start();
        void getQuestions();
    }
}
