package com.spaghetti.connect.mainFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.R;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link clubsPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class clubsPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btn;
    private RecyclerView clubList;
    FirebaseFirestore db;

    public clubsPage() {
        // Required empty public constructor0
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page3.
     */
    // TODO: Rename and change types and number of parameters
    public static clubsPage newInstance(String param1, String param2) {
        clubsPage fragment = new clubsPage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_clubspage, container, false);
        db = FirebaseFirestore.getInstance();
        DocumentReference userRef = db.collection("UserProfile").document("hBegFMYKgMJEkitE9GdF");
        userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    TextView test = root.findViewById(R.id.test);
                    DocumentSnapshot doc = task.getResult();
                    String testemail = doc.getString("Email");
                    test.setText(testemail);
                }
            }
        });
        return root;
    }
}