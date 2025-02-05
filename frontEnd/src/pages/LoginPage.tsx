import SocialKakao from "@components/login/SocialKakao";
import SocialNaver from "@components/login/SocialNaver";
import "@assets/styles/LoginPage.scss";

const LoginPage = () => {
  return (
    <div className="back h-[100vh]">
      <div className="profile-card">
        <div className="profile-bio">
          <div className="text-5xl text-white mt-20">LOGIN</div>
          <div className="flex justify-center mt-20 gap-10">
            <SocialNaver />
            <SocialKakao />
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
