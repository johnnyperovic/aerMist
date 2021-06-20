package llc.aerMist.app.ui.home.schedulere;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u0011J\b\u0010T\u001a\u00020PH\u0002J\"\u0010U\u001a\u00020P2\u0006\u0010V\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u00112\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u00020P2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0017J&\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010d\u001a\u00020P2\u0006\u0010e\u001a\u00020\\2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0006\u0010f\u001a\u00020PJ\u000e\u0010g\u001a\u00020P2\u0006\u0010S\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001a\u00104\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001a\u00107\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001a\u0010:\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015R\u001a\u0010=\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001a\u0010@\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R\u001a\u0010C\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\u001a\u0010F\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\u001a\u0010I\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0013\"\u0004\bK\u0010\u0015R\u001a\u0010L\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0013\"\u0004\bN\u0010\u0015\u00a8\u0006h"}, d2 = {"Lllc/aerMist/app/ui/home/schedulere/SetScheduleFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "eightTimmer", "Lllc/aerMist/app/models/TimerModel;", "getEightTimmer", "()Lllc/aerMist/app/models/TimerModel;", "setEightTimmer", "(Lllc/aerMist/app/models/TimerModel;)V", "fifthTimmer", "getFifthTimmer", "setFifthTimmer", "firstTimer", "getFirstTimer", "setFirstTimer", "fiveX", "", "getFiveX", "()I", "setFiveX", "(I)V", "fourX", "getFourX", "setFourX", "fourtTimmer", "getFourtTimmer", "setFourtTimmer", "mist", "", "getMist", "()Ljava/lang/String;", "setMist", "(Ljava/lang/String;)V", "numberOfOpenTimers", "getNumberOfOpenTimers", "setNumberOfOpenTimers", "numberPickerPopup", "Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "getNumberPickerPopup", "()Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "setNumberPickerPopup", "(Lllc/aerMist/app/ui/popup/NumberPickerPopup;)V", "numbers", "", "getNumbers", "()[I", "setNumbers", "([I)V", "oneX", "getOneX", "setOneX", "secondTimer", "getSecondTimer", "setSecondTimer", "seventhTimmer", "getSeventhTimmer", "setSeventhTimmer", "sixX", "getSixX", "setSixX", "sixthTimmer", "getSixthTimmer", "setSixthTimmer", "suspend", "getSuspend", "setSuspend", "thirdTimmer", "getThirdTimmer", "setThirdTimmer", "threeX", "getThreeX", "setThreeX", "twoX", "getTwoX", "setTwoX", "zeroX", "getZeroX", "setZeroX", "formatTime", "", "hour", "min", "position", "navigateToMain", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setNumberPicker", "setTimePicker", "app_localApiDebug"})
public final class SetScheduleFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.ui.popup.NumberPickerPopup numberPickerPopup;
    private int numberOfOpenTimers = 1;
    private int zeroX = 1;
    private int oneX = 1;
    private int twoX = 1;
    private int threeX = 1;
    private int fourX = 1;
    private int fiveX = 1;
    private int sixX = 1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mist = "0";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String suspend = "0";
    @org.jetbrains.annotations.NotNull()
    public int[] numbers;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel firstTimer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel secondTimer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel thirdTimmer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel fourtTimmer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel fifthTimmer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel sixthTimmer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel seventhTimmer;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.models.TimerModel eightTimmer;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.ui.popup.NumberPickerPopup getNumberPickerPopup() {
        return null;
    }
    
    public final void setNumberPickerPopup(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.ui.popup.NumberPickerPopup p0) {
    }
    
    public final int getNumberOfOpenTimers() {
        return 0;
    }
    
    public final void setNumberOfOpenTimers(int p0) {
    }
    
    public final int getZeroX() {
        return 0;
    }
    
    public final void setZeroX(int p0) {
    }
    
    public final int getOneX() {
        return 0;
    }
    
    public final void setOneX(int p0) {
    }
    
    public final int getTwoX() {
        return 0;
    }
    
    public final void setTwoX(int p0) {
    }
    
    public final int getThreeX() {
        return 0;
    }
    
    public final void setThreeX(int p0) {
    }
    
    public final int getFourX() {
        return 0;
    }
    
    public final void setFourX(int p0) {
    }
    
    public final int getFiveX() {
        return 0;
    }
    
    public final void setFiveX(int p0) {
    }
    
    public final int getSixX() {
        return 0;
    }
    
    public final void setSixX(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMist() {
        return null;
    }
    
    public final void setMist(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspend() {
        return null;
    }
    
    public final void setSuspend(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getNumbers() {
        return null;
    }
    
    public final void setNumbers(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getFirstTimer() {
        return null;
    }
    
    public final void setFirstTimer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getSecondTimer() {
        return null;
    }
    
    public final void setSecondTimer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getThirdTimmer() {
        return null;
    }
    
    public final void setThirdTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getFourtTimmer() {
        return null;
    }
    
    public final void setFourtTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getFifthTimmer() {
        return null;
    }
    
    public final void setFifthTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getSixthTimmer() {
        return null;
    }
    
    public final void setSixthTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getSeventhTimmer() {
        return null;
    }
    
    public final void setSeventhTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.TimerModel getEightTimmer() {
        return null;
    }
    
    public final void setEightTimmer(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.TimerModel p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void setTimePicker(int position) {
    }
    
    public final void setNumberPicker() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    private final void navigateToMain() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void formatTime(int hour, int min, int position) {
    }
    
    public SetScheduleFragment() {
        super();
    }
}