require 'test_helper'

class UrlshortenersControllerTest < ActionController::TestCase
  setup do
    @urlshortener = urlshorteners(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:urlshorteners)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create urlshortener" do
    assert_difference('Urlshortener.count') do
      post :create, urlshortener: { count: @urlshortener.count, url: @urlshortener.url }
    end

    assert_redirected_to urlshortener_path(assigns(:urlshortener))
  end

  test "should show urlshortener" do
    get :show, id: @urlshortener
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @urlshortener
    assert_response :success
  end

  test "should update urlshortener" do
    patch :update, id: @urlshortener, urlshortener: { count: @urlshortener.count, url: @urlshortener.url }
    assert_redirected_to urlshortener_path(assigns(:urlshortener))
  end

  test "should destroy urlshortener" do
    assert_difference('Urlshortener.count', -1) do
      delete :destroy, id: @urlshortener
    end

    assert_redirected_to urlshorteners_path
  end
end
