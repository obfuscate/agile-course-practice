package ru.unn.agile.Vec3.ViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Vector3ViewModelLoggerTest {
    private Vector3ViewModel viewModel;

    public void setViewModel(final Vector3ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Before
    public void initialize() {
        viewModel = new Vector3ViewModel(new Vector3FakeLogger());
    }

    @After
    public void shutdown() {
        viewModel = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void viewModelConstructorThrowExceptionWithNullLogger() {
        new Vector3ViewModel(null);
    }

    @Test
    public void canCreateViewModelWithFakeLogger() {
        assertNotNull(viewModel);
    }

    @Test
    public void viewModelHasEmptyLogAfterConstruction() {
        assertTrue(viewModel.getLog().isEmpty());
    }

    @Test
    public void canPushMessageWhenViewModelOperationIsChanged() {
        viewModel.setOperation(Vector3Operation.CALCULATE_CROSS_PRODUCT);

        viewModel.operationIsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordX0IsChanged() {
        viewModel.setCoordX0("Release me!");

        viewModel.checkCoordX0IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordY0IsChanged() {
        viewModel.setCoordY0("Nevermore!");

        viewModel.checkCoordY0IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordZ0IsChanged() {
        viewModel.setCoordZ0("Welcome to hell, J. J. Abrams!");

        viewModel.checkCoordZ0IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordX1IsChanged() {
        viewModel.setCoordX1("Meow!");

        viewModel.checkCoordX1IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordY1IsChanged() {
        final String message =
                "We'z gonna stomp da 'Ooniverse flat and kill anyfink zat fights back."
                + "B'cause we iz da Orks, and we iz made ter fight and win!!";
        viewModel.setCoordY1(message);

        viewModel.checkCoordY1IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }

    @Test
    public void canPushMessageWhenViewModelCoordZ1IsChanged() {
        viewModel.setCoordZ1("Lok'tar ogar!");

        viewModel.checkCoordZ1IsChanged();

        assertEquals(1, viewModel.getLog().size());
    }
}
