package xyz.cotoha.program.qa.ChatBot;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;
import java.util.TimeZone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ResolX.R;

public class ChatBotActivity extends AppCompatActivity {

    private MediaPlayer userSound;
    private MediaPlayer botSound;

    // 他のフィールドと同様に、メールアドレスが既に送信されたかどうかを追跡するフィールドを追加します。
    private boolean isAddressAlreadySent = false;
    private MessageAdapter adapter;
    private List<Message> messages;
    private Handler handler;
    private String greeting;  // 'ChatBotActivity'のフィールドにする
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        messages = new ArrayList<>();
        adapter = new MessageAdapter(messages);
        handler = new Handler();

        RecyclerView recyclerView = findViewById(R.id.message_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        userSound = MediaPlayer.create(this, R.raw.sousin);
        botSound = MediaPlayer.create(this, R.raw.sousin);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String[] botRandomMessages = {
                "申し訳ありません、私はAIではない為、以下の事以外には対応することができません。\n\n⑴ ショッピング\n⑵ 架空請求\n⑶ フィッシング詐欺\n\n※今後新しい内容を追加予定です※"
        };

        if (hour >= 4 && hour < 11) {
            greeting = "おはようございます！\nご用件はなんでしょうか？\n以下の内容からお選びください！\n\n⑴ ショッピング\n⑵ 架空請求\n⑶ フィッシング詐欺";
        } else if (hour >= 11 && hour < 18) {
            greeting = "こんにちは！\nご用件はなんでしょうか？\n以下の内容からお選びください！\n\n⑴ ショッピング\n⑵ 架空請求\n⑶ フィッシング詐欺";
        } else {
            greeting = "こんばんは！\nご用件はなんでしょうか？\n以下の内容からお選びください！\n\n⑴ ショッピング\n⑵ 架空請求\n⑶ フィッシング詐欺";
        }


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                botSound.start();
                messages.add(new Message(greeting, Message.Sender.BOT, false));
                adapter.notifyItemInserted(messages.size() - 1);
            }
        }, 1000);  // 1秒後に実行

        EditText inputMessage = findViewById(R.id.input_message);
        findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = inputMessage.getText().toString();
                if (!text.isEmpty()) {
                    userSound.start();
                    messages.add(new Message(text, Message.Sender.USER,false));
                    adapter.notifyItemInserted(messages.size() - 1);
                    recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                    inputMessage.setText("");

                    // ユーザーが送信したメッセージが特定のキーワードに一致しない場合に、ボットがランダムなメッセージを送信するようにします。
                    if (!text.equals("ショッピング") && !text.equals("名前") && !text.equals("架空請求") && !text.equals("フィッシング詐欺") && !text.equals("アドレス")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                // ランダムなメッセージを選択します。
                                String randomMessage = botRandomMessages[new Random().nextInt(botRandomMessages.length)];
                                messages.add(new Message(randomMessage, Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 2000);
                    }

                    if (text.equals("ショッピング")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                String randomMessage = botRandomMessages[new Random().nextInt(botRandomMessages.length)];
                                messages.add(new Message("名前を入力してください", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 2000);
                    }
                    if (text.equals("名前")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                String randomMessage = botRandomMessages[new Random().nextInt(botRandomMessages.length)];
                                messages.add(new Message("処理中です", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 2000);  // 「処理中です」メッセージの表示を1秒遅らせます。
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                String randomMessage = botRandomMessages[new Random().nextInt(botRandomMessages.length)];
                                messages.remove(messages.size() - 1);  // 「処理中」メッセージを削除
                                adapter.notifyItemRemoved(messages.size());  // 削除を通知
                                messages.add(new Message("次にメールアドレスを入力してください\nアドレスと入力してください（botから返事が返ってきたらもう一度アドレスと入力してください）", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 7000);  // 「次にメールアドレスを入力してください」メッセージの表示を3秒後（「処理中です」メッセージの表示から4秒後）に設定します。
                    }

                    if (text.equals("アドレス")) {
                        if (isAddressAlreadySent) {
                            // メールアドレスが既に送信されている場合、エラーメッセージを表示します。
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    String randomMessage = botRandomMessages[new Random().nextInt(botRandomMessages.length)];
                                    messages.add(new Message("このメールアドレスは既に登録されているため使えません", Message.Sender.BOT, true));
                                    recyclerView.scrollToPosition(messages.size() - 1);
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 2000);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.add(new Message("Q：なぜ？\n\nA：最初にアドレスを送信したときに、リアルタイムでサーバーで処理がされてしまっているからです。", Message.Sender.BOT, false));
                                    recyclerView.scrollToPosition(messages.size() - 1);
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 5000);

                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.add(new Message("Q：リアルタイム処理とは？\n\nA：購入ボタンを押した瞬間に、在庫の確認、支払い方法の確認、配送先の確認、注文の確定などの全ての処理が即座に行われることです。", Message.Sender.BOT, false));
                                    recyclerView.scrollToPosition(messages.size() - 1);
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 7000);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.add(new Message("Q：サーバーって何？\n\nA：サーバーは郵便局のようなものです。郵便局（サーバー）は、人々（クライアント）が送りたい手紙やパッケージ（データ）を受け取り、適切な宛先に配達します。また、郵便局は人々からの手紙やパッケージを保管し、それらが必要なときに提供します。このように、サーバーはクライアントからの要求を受けてデータを送受信し、必要に応じてデータを保管します。", Message.Sender.BOT, false));
                                    recyclerView.scrollToPosition(messages.size() - 1);
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 10000);

                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.add(new Message("Q：どうしたらいい？\n\nA：一度仮登録のメールが来ているか確認して、来ていたら本登録をしてください。\nパスワードの入力が必要な場合リセットしてください。\n不可能な場合は違うメールアドレスで再度登録してください。", Message.Sender.BOT, false));
                                    recyclerView.scrollToPosition(messages.size() - 1);
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 13000);
                        } else {
                            // メールアドレスがまだ送信されていない場合、通常の処理を行い、フラグを更新します。
                            isAddressAlreadySent = true;
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.add(new Message("処理中です", Message.Sender.BOT,false));
                                    recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 2000);  // 「処理中です」メッセージの表示を1秒遅らせます。
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    botSound.start();
                                    messages.remove(messages.size() - 1);  // 「処理中」メッセージを削除
                                    adapter.notifyItemRemoved(messages.size());  // 削除を通知
                                    messages.add(new Message("メールアドレスの登録が完了しました", Message.Sender.BOT,false));
                                    recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                    adapter.notifyItemInserted(messages.size() - 1);
                                }
                            }, 4000);  // 「メールアドレスの登録が完了しました」メッセージの表示を3秒後（「処理中です」メッセージの表示から4秒後）に設定します。
                        }
                    }

                    if (text.equals("架空請求")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("了解しました。\n以下に架空請求の例文を送信致します。", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 2000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("件名：【重要】未払い料金のお知らせ\n" +
                                        "\n" +
                                        "お客様へ、\n" +
                                        "\n" +
                                        "この度は、当社のサービスをご利用いただき、誠にありがとうございます。\n" +
                                        "\n" +
                                        "しかしながら、現在お客様のアカウントに未払いの料金が発生しております。\n" +
                                        "\n" +
                                        "【未払い料金詳細】\n" +
                                        "・サイト利用料金：¥10,000\n" +
                                        "・遅延料金：¥5,000\n" +
                                        "合計：¥15,000\n" +
                                        "\n" +
                                        "お客様のご都合により未払いが発生した場合、法的手続きを開始せざるを得ません。お客様の個人情報を調査し、裁判所からの強制執行を行う可能性があります。\n" +
                                        "\n" +
                                        "お手数ですが、下記の電話番号まで至急ご連絡ください。\n" +
                                        "\n" +
                                        "電話番号：090-1234-5678\n" +
                                        "\n" +
                                        "何卒、ご理解とご協力をお願い申し上げます。", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 5000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("-----------------------------------\n" +
                                        "件名：【最終通告】Spotify Premiumの未払い料金について\n" +
                                        "\n" +
                                        "尊敬するお客様へ、\n" +
                                        "\n" +
                                        "Spotify Premiumをご愛用いただき、心より感謝申し上げます。\n" +
                                        "\n" +
                                        "しかしながら、お客様のアカウントに未払いの料金が確認されました。これは、無料期間が終了し、有料プランに自動的に移行した結果です。\n" +
                                        "\n" +
                                        "【未払い料金詳細】\n" +
                                        "・Spotify Premium利用料金：¥980\n" +
                                        "・遅延料金：¥490\n" +
                                        "・特別サービス料金：¥5,000\n" +
                                        "・データ復旧料金：¥10,000\n" +
                                        "・システム利用料金：¥15,000\n" +
                                        "合計：¥31,470\n" +
                                        "\n" +
                                        "このまま未払いが続くと、法的手続きを開始せざるを得ません。お客様の個人情報を調査し、裁判所からの強制執行を行う可能性があります。また、開示請求を行う可能性もあります。\n" +
                                        "\n" +
                                        "お手数ですが、下記の電話番号まで至急ご連絡ください。\n" +
                                        "\n" +
                                        "電話番号：080-1234-5678\n" +
                                        "\n" +
                                        "何卒、ご理解とご協力を賜りますようお願い申し上げます。\n" +
                                        "\n" +
                                        "-----------------------------------\n", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 10000);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("架空請求とは、実際には利用していないサービスや商品の料金を請求する詐欺の一種です\n。メールやハガキ、電話などで突然「料金が未払いだ」と連絡が来ることがあります。\n" +
                                        "\n" +
                                        "しかし、大切なことは「身に覚えのない請求には絶対に応じない」ことです。また、個人情報を教えないようにしましょう。\n" +
                                        "\n" +
                                        "もし、こんなメールや電話が来たら、次のように対処してください：\n" +
                                        "\n" +
                                        "1. メールや電話で請求が来たら、まずは落ち着いてください。焦らないことが大切です。\n" +
                                        "2. 身に覚えのない請求には、絶対に応じないでください。また、個人情報を教えないようにしましょう。\n" +
                                        "3. それでも不安な場合は、消費生活センターなどに相談してください。\n" +
                                        "\n" +
                                        "インターネットは便利な反面、悪用する人もいます。だからこそ、注意深く利用することが大切です。何かわからないことがあったら、信頼できる人に相談しましょう。\n", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 14000);
                    }

                    if (text.equals("フィッシング詐欺")) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("了解しました。\n以下にフィッシング詐欺の例文を送信します。", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 2000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("-----------------------------------\n" +
                                        "件名：【重要】あなたのSpotifyアカウントがロックされました\n" +
                                        "\n" +
                                        "尊敬するSpotifyユーザー様へ、\n" +
                                        "\n" +
                                        "Spotifyをご愛用いただき、心より感謝申し上げます。\n" +
                                        "\n" +
                                        "しかしながら、お客様のアカウントに異常なログイン試行が確認されました。お客様の安全を確保するため、一時的にアカウントをロックしています。\n" +
                                        "\n" +
                                        "アカウントを再度利用するには、以下のリンクからパスワードをリセットしてください。\n" +
                                        "\n" +
                                        "パスワードをリセットする：http://www.spotify-account-reset.com\n" +
                                        "\n" +
                                        "何卒、ご理解とご協力を賜りますようお願い申し上げます。\n" +
                                        "\n" +
                                        "-----------------------------------\n", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 4000);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                botSound.start();
                                messages.add(new Message("フィッシング詐欺とは、実在する企業や組織を装ってメールを送り不正なウェブサイトに誘導し\n個人情報をだまし取ろうとするものです。\n" +
                                        "\n" +
                                        "もし、こんなメールが来たら、次のように対処してください：\n" +
                                        "\n" +
                                        "1. メールの送信元や内容をよく確認しましょう。送信元が怪しい場合や、リンクをクリックするように促される場合は特に注意が必要です。\n" +
                                        "2. メールに書かれているリンクをクリックせず、公式のウェブサイトやアプリから直接ログインして状況を確認しましょう。\n" +
                                        "3. メールの送信元やリンク先のURLが怪しいと思ったら、すぐに削除しましょう。\n" +
                                        "4. それでも不安な場合は、信頼できる人に相談しましょう。\n" +
                                        "\n" +
                                        "インターネットは便利な反面、悪用する人もいます。だからこそ、注意深く利用することが大切です。何かわからないことがあったら、信頼できる人に相談しましょう。\n", Message.Sender.BOT,false));
                                recyclerView.scrollToPosition(messages.size() - 1);  // 追加
                                adapter.notifyItemInserted(messages.size() - 1);
                            }
                        }, 8000);
                    }

                }
            }
        });
    }
}
