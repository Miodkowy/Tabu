package com.michal_stasinski.tabu.Utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.michal_stasinski.tabu.MainActivity;
import com.michal_stasinski.tabu.Menu.DataForDelivery;
import com.michal_stasinski.tabu.Menu.Models.StaffMember;
import com.michal_stasinski.tabu.Menu.ShopingCard;
import com.michal_stasinski.tabu.R;

import static com.michal_stasinski.tabu.SplashScreen.IS_LOGGED_IN;
import static com.michal_stasinski.tabu.SplashScreen.IS_STAFF_MEMBER;
import static com.michal_stasinski.tabu.SplashScreen.staffTeamArray;

/**
 * Created by win8 on 21.07.2017.
 */

public class Do_you_belong_to_staff extends Activity {
    private String _email;
    private String _firstname;
    private String _password;
    private String _phone;
    private String _surname;
    private String _userId;


    public Do_you_belong_to_staff(final Activity activity, String firstname, String surname, String email, String phone) {

        _firstname = firstname;
        _surname = surname;
        _email = email;
        _phone = phone;

        for (int i = 0; i < staffTeamArray.size(); i++) {

            String fn = staffTeamArray.get(i).getFirstname().toString();
            String sn = staffTeamArray.get(i).getSurname().toString();
            String em = staffTeamArray.get(i).getEmail().toString();
            String ph = staffTeamArray.get(i).getPhone().toString();


            if (_firstname.equals(fn) && _surname.equals(sn) && _email.equals(em) && _phone.equals(ph)) {

                Log.i("informacja", "przeszło 2");
                Log.i("informacja", _firstname + " firstname " + fn);
                Log.i("informacja", _surname + " surname " + sn);
                Log.i("informacja", _email + " email " + em);
                Log.i("informacja", _phone + " phone " + ph);

                _password = staffTeamArray.get(i).getPassword().toString();
                Log.i("informacja", " _password " + _password);

                IS_STAFF_MEMBER = true;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
                alertDialog.setTitle("Witaj " + firstname + " " + surname);
                alertDialog.setMessage("Wpisz hasło");

                final EditText input = new EditText(activity);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                alertDialog.setPositiveButton("TAK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String pass = input.getText().toString();
                                Log.i("informacja", pass + " pass " + _password);

                                if (pass.compareTo("") != 0) {
                                    if (pass.equals(_password)) {
                                        Toast.makeText(activity, "Jesteś zalogowany", Toast.LENGTH_SHORT).show();
                                        IS_LOGGED_IN = true;
                                        activity.recreate();


                                    } else {
                                        IS_LOGGED_IN = false;
                                        Toast.makeText(activity, "Nieprawidłowe hasło!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {

                                }
                            }
                        });

                alertDialog.setNegativeButton("NIE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }


        }

    }
}
