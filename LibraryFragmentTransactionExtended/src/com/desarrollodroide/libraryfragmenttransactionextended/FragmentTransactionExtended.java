package com.desarrollodroide.libraryfragmenttransactionextended;

import com.desarrollodroide.libraryfragmenttransitionextended.R;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;


public class FragmentTransactionExtended implements FragmentManager.OnBackStackChangedListener {
    private boolean mDidSlideOut = false;
    private boolean mIsAnimating = false;
    private FragmentTransaction mFragmentTransaction;
    private Context mContext;
    private Fragment mFirstFragment, mSecondFragment;
    private int mContainerID;
    private int mTransitionType;
    public static final int SCALEX = 0;
    public static final int SCALEY = 1;
    public static final int SCALEXY = 2;
    public static final int FADE = 3;
    public static final int FLIP_HORIZONTAL = 4;
    public static final int FLIP_VERTICAL = 5;
    public static final int SLIDE_VERTICAL = 6;
    public static final int SLIDE_HORIZONTAL = 7;
    public static final int SLIDE_HORIZONTAL_PUSH_TOP = 8;
    public static final int SLIDE_VERTICAL_PUSH_LEFT = 9;
    public static final int GLIDE = 10;
    public static final int SLIDING = 11;
    public static final int STACK = 12;
    public static final int CUBE = 13;
    public static final int ROTATE_DOWN = 14;
    public static final int ROTATE_UP = 15;
    public static final int ACCORDION = 16;
    public static final int TABLE_HORIZONTAL = 17;
    public static final int TABLE_VERTICAL = 18;
    public static final int ZOOM_FROM_LEFT_CORNER = 19;
    public static final int ZOOM_FROM_RIGHT_CORNER = 20;



    public FragmentTransactionExtended(Context context, FragmentTransaction fragmentTransaction, Fragment firstFragment, Fragment secondFragment, int containerID) {
        this.mFragmentTransaction = fragmentTransaction;
        this.mContext = context;
        this.mFirstFragment = firstFragment;
        this.mSecondFragment = secondFragment;
        this.mContainerID = containerID;
    }

    public void addTransition(int transitionType) {
        this.mTransitionType = transitionType;
        switch (transitionType) {
            case SCALEX:
                transitionScaleX();
                break;
            case SCALEY:
                transitionScaleY();
                break;
            case SCALEXY:
                transitionScaleXY();
                break;
            case FADE:
                transitionFade();
                break;
            case FLIP_HORIZONTAL:
                transitionFlipHorizontal();
                break;
            case FLIP_VERTICAL:
                transitionFlipVertical();
                break;
            case SLIDE_VERTICAL:
                transitionSlideVertical();
                break;
            case SLIDE_HORIZONTAL:
                transitionSlideHorizontal();
                break;
            case SLIDE_HORIZONTAL_PUSH_TOP:
                transitionSlideHorizontalPushTop();
                break;
            case SLIDE_VERTICAL_PUSH_LEFT:
                transitionSlideVerticalPushLeft();
                break;
            case GLIDE:
                transitionGlide();
                break;
            case SLIDING:
                return;
            case STACK:
                transitionStack();
                break;
            case CUBE:
                transitionCube();
                break;
            case ROTATE_DOWN:
                transitionRotateDown();
                break;
            case ROTATE_UP:
                transitionRotateUp();
                break;
            case ACCORDION:
                transitionAccordion();
                break;
            case TABLE_HORIZONTAL:
                transitionTableHorizontal();
                break;
            case TABLE_VERTICAL:
                transitionTableVertical();
                break;
            case ZOOM_FROM_LEFT_CORNER:
            	transitionZoomFromLeftCorner();
                break;
            case ZOOM_FROM_RIGHT_CORNER:
            	transitionZoomFromRightCorner();
                break;
        }
        mFragmentTransaction.replace(mContainerID, mSecondFragment);
    }

    private void transitionFade() {
        mFragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
    }

    private void transitionScaleX() {
        mFragmentTransaction.setCustomAnimations(R.animator.scalex_enter, R.animator.scalex_exit, R.animator.scalex_enter, R.animator.scalex_exit);
    }

    private void transitionScaleY() {
        mFragmentTransaction.setCustomAnimations(R.animator.scaley_enter, R.animator.scaley_exit, R.animator.scaley_enter, R.animator.scaley_exit);
    }

    private void transitionScaleXY() {
        mFragmentTransaction.setCustomAnimations(R.animator.scalexy_enter, R.animator.scalexy_exit, R.animator.scalexy_enter, R.animator.scalexy_exit);
    }

    private void transitionSlideVertical() {
        mFragmentTransaction.setCustomAnimations(R.animator.slide_fragment_vertical_right_in, R.animator.slide_fragment_vertical_left_out, R.animator.slide_fragment_vertical_left_in, R.animator.slide_fragment_vertical_right_out);
    }

    private void transitionSlideHorizontal() {
        mFragmentTransaction.setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_horizontal_right_out);
    }

    private void transitionSlideHorizontalPushTop() {
        mFragmentTransaction.setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_vertical_left_out, R.animator.slide_fragment_vertical_left_in, R.animator.slide_fragment_horizontal_right_out);
    }

    private void transitionSlideVerticalPushLeft() {
        mFragmentTransaction.setCustomAnimations(R.animator.slide_fragment_vertical_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_vertical_right_out);
    }

    private void transitionGlide() {
        mFragmentTransaction.setCustomAnimations(R.animator.glide_fragment_horizontal_in, R.animator.glide_fragment_horizontal_out, R.animator.glide_fragment_horizontal_in, R.animator.glide_fragment_horizontal_out);
    }
    private void transitionStack() {
        mFragmentTransaction.setCustomAnimations(R.animator.stack_right_in, R.animator.stack_left_out, R.animator.stack_left_in, R.animator.stack_right_out);
    }

    private void transitionCube() {
        mFragmentTransaction.setCustomAnimations(R.animator.cube_right_in, R.animator.cube_left_out, R.animator.cube_left_in, R.animator.cube_right_out);
    }

    private void transitionRotateDown() {
        mFragmentTransaction.setCustomAnimations(R.animator.rotatedown_right_in, R.animator.rotatedown_left_out, R.animator.rotatedown_left_in, R.animator.rotatedown_right_out);
    }

    private void transitionRotateUp() {
        mFragmentTransaction.setCustomAnimations(R.animator.rotateup_right_in, R.animator.rotateup_left_out, R.animator.rotateup_left_in, R.animator.rotateup_right_out);
    }

    private void transitionAccordion() {
        mFragmentTransaction.setCustomAnimations(R.animator.accordion_right_in, R.animator.accordion_left_out, R.animator.accordion_left_in, R.animator.accordion_right_out);
    }

    private void transitionTableHorizontal() {
        mFragmentTransaction.setCustomAnimations(R.animator.table_horizontal_right_in, R.animator.table_horizontal_left_out, R.animator.table_horizontal_left_int, R.animator.table_horizontal_right_out);
    }

    private void transitionTableVertical() {
        mFragmentTransaction.setCustomAnimations(R.animator.table_vertical_right_in, R.animator.table_vertical_left_out, R.animator.table_vertical_left_int, R.animator.table_vertical_right_out);
    }

    private void transitionFlipHorizontal() {
        mFragmentTransaction.setCustomAnimations(R.animator.card_flip_horizontal_right_in, R.animator.card_flip_horizontal_left_out, R.animator.card_flip_horizontal_left_in, R.animator.card_flip_horizontal_right_out);
    }

    private void transitionFlipVertical() {
        mFragmentTransaction.setCustomAnimations(R.animator.card_flip_vertical_right_in, R.animator.card_flip_vertical_left_out, R.animator.card_flip_vertical_left_in, R.animator.card_flip_vertical_right_out);
    }
    
    private void transitionZoomFromLeftCorner() {
        mFragmentTransaction.setCustomAnimations(R.animator.zoom_from_left_corner_right_in, R.animator.zoom_from_left_corner_left_out, R.animator.zoom_from_left_corner_left_in, R.animator.zoom_from_left_corner_right_out);
    }
    
    private void transitionZoomFromRightCorner() {
        mFragmentTransaction.setCustomAnimations(R.animator.zoom_from_right_corner_right_in, R.animator.zoom_from_right_corner_left_out, R.animator.zoom_from_right_corner_left_in, R.animator.zoom_from_right_corner_right_out);
    }


    private void switchFragments() {
        ((Activity) this.mContext).getFragmentManager().addOnBackStackChangedListener(this);

        if (mIsAnimating) {
            return;
        }
        mIsAnimating = true;
        if (mDidSlideOut) {
            mDidSlideOut = false;
            ((Activity) mContext).getFragmentManager().popBackStack();
        } else {
            mDidSlideOut = true;
            Animator.AnimatorListener listener = new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator arg0) {
                    mFragmentTransaction.setCustomAnimations(R.animator.slide_fragment_in, 0, 0, R.animator.slide_fragment_out);
                    mFragmentTransaction.add(mContainerID, mSecondFragment);
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                }
            };
            slideBack(listener);
        }
    }

    public void slideBack(Animator.AnimatorListener listener) {
        View movingFragmentView = mFirstFragment.getView();
        movingFragmentView.setPivotY(movingFragmentView.getHeight()/2);
        movingFragmentView.setPivotX(movingFragmentView.getWidth() / 2);

        PropertyValuesHolder rotateX = PropertyValuesHolder.ofFloat("rotationX", 40f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.8f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.8f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.5f);
        ObjectAnimator movingFragmentAnimator = ObjectAnimator.ofPropertyValuesHolder(movingFragmentView, rotateX, scaleX, scaleY, alpha);

        ObjectAnimator movingFragmentRotator = ObjectAnimator.ofFloat(movingFragmentView, "rotationX", 0);
        movingFragmentRotator.setStartDelay(mContext.getResources().getInteger(R.integer.half_slide_up_down_duration));

        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator, movingFragmentRotator);
        s.addListener(listener);
        s.start();
    }

    public void slideForward() {
        View movingFragmentView = mFirstFragment.getView();
        PropertyValuesHolder rotateX = PropertyValuesHolder.ofFloat("rotationX", 40f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1f);
        ObjectAnimator movingFragmentAnimator = ObjectAnimator.ofPropertyValuesHolder(movingFragmentView, rotateX, scaleX, scaleY, alpha);

        ObjectAnimator movingFragmentRotator = ObjectAnimator.ofFloat(movingFragmentView, "rotationX", 0);
        movingFragmentRotator.setStartDelay(mContext.getResources().getInteger(R.integer.half_slide_up_down_duration));

        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator, movingFragmentRotator);
        s.setStartDelay(mContext.getResources().getInteger(R.integer.slide_up_down_duration));
        s.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mIsAnimating = false;
                mDidSlideOut = true;
            }
        });
        s.start();
        ((Activity) this.mContext).getFragmentManager().removeOnBackStackChangedListener(this);
    }


    public void commit(){
        switch (mTransitionType){
            case SLIDING:
                switchFragments();
                break;
            default:
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onBackStackChanged() {
        switch (mTransitionType){
            case SLIDING:
                if (!mDidSlideOut) {
                        slideForward();
                }else{
                    mDidSlideOut= false;
                }
                break;
        }
    }
}
