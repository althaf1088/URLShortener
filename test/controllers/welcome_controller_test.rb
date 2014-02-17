require 'test_helper'

class WelcomeControllerTest < ActionController::TestCase
  test "should get indexrails" do
    get :indexrails
    assert_response :success
  end

  test "should get generate" do
    get :generate
    assert_response :success
  end

  test "should get controller" do
    get :controller
    assert_response :success
  end

  test "should get welcome" do
    get :welcome
    assert_response :success
  end

  test "should get index$" do
    get :index
    assert_response :success
  end

end
