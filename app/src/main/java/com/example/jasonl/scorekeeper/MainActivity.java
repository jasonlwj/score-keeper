package com.example.jasonl.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button TeamAGoalButton = (Button) findViewById(R.id.team_a_goal_button);
        Button TeamABehindButton = (Button) findViewById(R.id.team_a_behind_button);
        Button TeamBGoalButton = (Button) findViewById(R.id.team_b_goal_button);
        Button TeamBBehindButton = (Button) findViewById(R.id.team_b_behind_button);
        Button ResetButton = (Button) findViewById(R.id.reset_button);

        TeamAGoalButton.setOnClickListener(myClickListener);
        TeamABehindButton.setOnClickListener(myClickListener);
        TeamBGoalButton.setOnClickListener(myClickListener);
        TeamBBehindButton.setOnClickListener(myClickListener);
        ResetButton.setOnClickListener(myClickListener);

        updateScoreDisplay();
    }

    /**
     * Create an instance of Android's OnClickListener to handle clicks for different buttons in the app
      */
    private OnClickListener myClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case (R.id.team_a_goal_button):
                    addPoints("Team A", 6);
                    break;
                case (R.id.team_a_behind_button):
                    addPoints("Team A", 1);
                    break;
                case (R.id.team_b_goal_button):
                    addPoints("Team B", 6);
                    break;
                case (R.id.team_b_behind_button):
                    addPoints("Team B", 1);
                    break;
                case (R.id.reset_button):
                    resetScore();
                    break;
            }

            updateScoreDisplay();
        }
    };

    /**
     * Add a specified number of points to the specified team
     * @param teamName: name of the team whose score is increased e.g. "Team A"
     * @param points: number of points to be added to the team score
     */
    private void addPoints(String teamName, int points) {
        if (teamName.equals("Team A")) teamAScore += points;
        else if (teamName.equals("Team B")) teamBScore += points;
    }

    /**
     * Reset the scores for all teams to 0
     */
    private void resetScore() {
        teamAScore = 0;
        teamBScore = 0;
    }

    /**
     * Update the TextViews for the team scores to reflect the current value of the scores
     */
    private void updateScoreDisplay() {
        TextView teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.team_b_score);
        teamAScoreTextView.setText(String.format(Locale.getDefault(), "%d", teamAScore));
        teamBScoreTextView.setText(String.format(Locale.getDefault(), "%d", teamBScore));
    }
}
